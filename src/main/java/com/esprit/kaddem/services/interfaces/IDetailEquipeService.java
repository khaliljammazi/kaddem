package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    List<DetailEquipe> retrieveAllDetails();

    DetailEquipe addDetail(DetailEquipe d);

    DetailEquipe updateDetail(DetailEquipe d);

    DetailEquipe retrieveDetail(Integer idDetail);

    void deleteDetail(DetailEquipe d);

}
