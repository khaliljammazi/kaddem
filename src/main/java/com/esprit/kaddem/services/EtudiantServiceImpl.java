package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Contrat;
import com.esprit.kaddem.entites.Department;
import com.esprit.kaddem.entites.Equipe;
import com.esprit.kaddem.entites.Etudiant;
import com.esprit.kaddem.repositories.*;
import com.esprit.kaddem.services.interfaces.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    DepartmentRepository departmentRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;

    private final DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }


    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void deleteEtudiant(Etudiant e) {
        etudiantRepository.delete(e);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, int departementId) {
        Etudiant etud = etudiantRepository.findById(etudiantId).orElse(null);
        Department departement = departmentRepository.findById(departementId).orElse(null);
        etud.setDepartment(departement);
        etudiantRepository.save(etud);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiantsByDepartement(int departementId) {
        return etudiantRepository.findByDepartmentIdDepartment(departementId);
    }
    //@Transactional finish all or stop
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e,
                                                            Integer idContrat,
                                                            Integer idEquipe
                                                              )
    {
        Equipe equipe = equipeRepository.findById(idEquipe).get();

        Contrat contrat = contratRepository.findById(idContrat).get();

        Etudiant etudiant = etudiantRepository.save(e);

        equipe.getEtudiants().add(etudiant);
        equipeRepository.save(equipe);

        contrat.setEtudiant(etudiant);
        contratRepository.save(contrat);

        return e;
    }
}
