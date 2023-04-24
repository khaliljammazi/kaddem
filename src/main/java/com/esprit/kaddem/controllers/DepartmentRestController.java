package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entites.Department;
import com.esprit.kaddem.services.DepartmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentRestController {
    DepartmentServiceImpl departmentService;
@PostMapping("/add-department")
public void addDepartment(@RequestBody Department d) {
    departmentService.addDepartment(d);
}

    @PutMapping("/asign-etudiant/{idDepartement}/to-department/{idEtudiant}")
    public void asignEtudiantADepartment(
            @PathVariable("idDepartement") Integer idDepartement,
            @PathVariable("idEtudiant") Integer idEtudiant
    ){
        departmentService.asignEtudiantADepartment(idDepartement, idEtudiant);
    }

    @GetMapping("retrieve-departements-where-id-universite={idUniversite}")
    public List<Department> retrieveDepartementsByUniversite(@PathVariable("idUniversite") Integer idUniversite){
        return departmentService.retrieveDepartementsByUniversite(idUniversite);
    }
}
