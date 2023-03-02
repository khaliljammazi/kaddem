package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Contrat;
import com.esprit.kaddem.repositories.ContratRepository;
import com.esprit.kaddem.services.interfaces.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
