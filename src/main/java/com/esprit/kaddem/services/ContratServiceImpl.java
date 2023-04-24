package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Contrat;
import com.esprit.kaddem.repositories.ContratRepository;
import com.esprit.kaddem.services.interfaces.IContratService;
import lombok.extern.java.Log;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service


public class ContratServiceImpl implements IContratService {
    ContratRepository contratRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public void deleteContrat(Contrat c) {
      contratRepository.delete(c);
    }
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Log.class.getName());

    @Scheduled(fixedDelay = 20000)
    void retrieveAndUpdateStatusContrat(){
        List<Contrat> contratList;
        contratList = contratRepository.findAll();
        Date limitDate = new Date(System.currentTimeMillis() + 15 * 24 * 60 * 60 * 1000);

        contratList.stream().filter(
                contrat -> {
                    if(limitDate.getTime()-contrat.getDateFin().getTime()>0)
                        return true;
                    return false;
                }
        ).forEach(
                contrat -> log.info("THIS CONTRAT ID: "+contrat.getIdContract()+" WILL BE EN IN "+contrat.getDateFin())
        );

    }
}
