package com.esprit.kaddem.services;


import com.esprit.kaddem.entites.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e);

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);

    void deleteEquipe(Equipe equipe);
}
