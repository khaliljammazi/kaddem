package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entites.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {

 Universite  findByIdUnive(long idUnive);

}
