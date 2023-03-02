package com.esprit.kaddem.services;

import com.esprit.kaddem.entites.Department;

import java.util.List;

public interface IDepartmentService {

    List<Department> retrieveAllDepartments();

    Department addDepartment(Department d);

    Department updateDepartment(Department d);

    Department retrieveDepartment(Integer idDepartment);
    void deleteDepartment(Department d);
    Department addDepartementWithUniversite(Department d, Integer universiteId);

}
