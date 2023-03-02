package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Department;
import com.esprit.kaddem.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements com.esprit.kaddem.services.IDepartmentService {

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


}
