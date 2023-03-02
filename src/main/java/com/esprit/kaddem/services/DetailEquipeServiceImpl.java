package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.DetailEquipe;
import com.esprit.kaddem.repositories.DetailEquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeServiceImpl implements IDetailEquipeService{
DetailEquipeRepository detailEquipeRepository;
    @Override
    public List<DetailEquipe> retrieveAllDetails() {
        return   detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetail(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public DetailEquipe updateDetail(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public DetailEquipe retrieveDetail(Integer idDetail) {
        return detailEquipeRepository.findById(idDetail).get();
    }

    @Override
    public void deleteDetail(DetailEquipe d) {
        detailEquipeRepository.delete(d);
    }

}
