package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department,Integer> {
  Department  findDepartmentByIdDepartment(int idDepartment);

}
