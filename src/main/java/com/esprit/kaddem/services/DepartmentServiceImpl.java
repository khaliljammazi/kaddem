package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Department;
import com.esprit.kaddem.entites.Etudiant;
import com.esprit.kaddem.entites.Universite;
import com.esprit.kaddem.repositories.DepartmentRepository;
import com.esprit.kaddem.repositories.EtudiantRepository;
import com.esprit.kaddem.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements com.esprit.kaddem.services.IDepartmentService {
    EtudiantRepository etudiantRepository;
    UniversiteRepository universiteRepository;
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> retrieveAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department updateDepartment(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department retrieveDepartment(Integer idDepartment) {
        return departmentRepository.findById(idDepartment).get();
    }

    @Override
    public void deleteDepartment(Department d) {
        departmentRepository.delete(d);

    }

    @Override
    public Department addDepartementWithUniversite(Department d, Integer universiteId) {
        return null;
    }

    public List<Department> retrieveDepartementsByUniversite(long idUniversite) {
        Universite universite = universiteRepository.findByIdUnive(idUniversite);
        if(universite == null)
            return null;

        return universite.getDepartments();
    }
    public void asignEtudiantADepartment(Integer idDepartement, Integer idEtudiant) {
        Department department = departmentRepository.findDepartmentByIdDepartment(idDepartement);
        Etudiant etudiant = etudiantRepository.findEtudiantByIdEtudiant(idEtudiant);
        if(department != null && etudiant != null){
            etudiant.setDepartment(department);
            etudiantRepository.save(etudiant);
        }

    }
}
