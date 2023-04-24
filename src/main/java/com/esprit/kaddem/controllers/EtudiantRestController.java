package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entites.Etudiant;
import com.esprit.kaddem.services.EtudiantServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    EtudiantServiceImpl etudiantService;

    @PostMapping("/add-etudiant")
    public void addEtudiant(@RequestBody Etudiant e) {
        etudiantService.addEtudiant(e);
    }

    @PutMapping("/add-etud-departement/{etudiantId}/{departementId}")
    public void affecterEtudiantToDepartement(@PathVariable("etudiantId") Integer etudiantId, @PathVariable("departementId") int departementId) {
        etudiantService.assignEtudiantToDepartement(etudiantId, departementId);
    }
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    @PostMapping("/asgin-etudiant-contrat-equipe/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(
            @RequestBody Etudiant etudiant,
            @PathVariable("idContrat") Integer idContrat,
            @PathVariable("idEquipe")  Integer idEquipe
    ){
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, idContrat, idEquipe);
    }


}
