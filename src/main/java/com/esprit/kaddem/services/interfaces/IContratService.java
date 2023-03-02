package com.esprit.kaddem.services.interfaces;

import com.esprit.kaddem.entites.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat addContrat(Contrat c);

    Contrat updateContrat(Contrat c);

    Contrat retrieveContrat(Integer idContrat);

    void deleteContrat(Contrat c);
}
