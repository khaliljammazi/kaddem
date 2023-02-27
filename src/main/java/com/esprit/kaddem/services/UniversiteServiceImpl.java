package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Universite;
import com.esprit.kaddem.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImpl implements IUniversiteService {

    UniversiteRepository UniversiteRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return UniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return UniversiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return UniversiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return UniversiteRepository.findById(idUniversite).get();
    }

    @Override
    public void deleteUniversite(Universite u) {
        UniversiteRepository.delete(u);

    }
}
