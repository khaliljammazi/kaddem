package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entites.Etudiant;
import com.esprit.kaddem.services.EtudiantServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public void affecterEtudiantToDepartement(@PathVariable("etudiantId") Integer etudiantId, @PathVariable("departementId")int departementId){
        etudiantService.assignEtudiantToDepartement(etudiantId, departementId);
    }



}
