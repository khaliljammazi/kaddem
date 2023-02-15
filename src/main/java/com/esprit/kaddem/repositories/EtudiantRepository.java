package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entites.Etudiant;
import com.esprit.kaddem.entites.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    List<Etudiant> findByDepartmentIdDepartment(long idDepartment);

    List<Etudiant> findByEquipesNiveau(Niveau niveau);
}
