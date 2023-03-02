package com.esprit.kaddem.services.interfaces;

import com.esprit.kaddem.entites.Etudiant;

import java.util.List;

public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void deleteEtudiant(Etudiant e);

    public void assignEtudiantToDepartement (Integer etudiantId , int departementId );


}
