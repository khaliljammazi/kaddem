package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Department;
import com.esprit.kaddem.entites.Universite;
import com.esprit.kaddem.repositories.UniversiteRepository;
import com.esprit.kaddem.services.interfaces.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImpl implements IUniversiteService {

    UniversiteRepository UniversiteRepository;
  DepartmentServiceImpl departmentService;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return UniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        Universite newUniversite = UniversiteRepository.save(u);
        //create deaprtment for this university
        Department department = new Department();
        //generate random id
        department.setIdDepartment((int) (Math.random() * 1000));
        department.setNameDepartment("Department of " + newUniversite.getNomUniversite());
        departmentService.addDepartment(department);
        newUniversite.setDepartments((List<Department>) department);
        return newUniversite;
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
