package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entites.Department;
import com.esprit.kaddem.services.DepartmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentRestController {
    DepartmentServiceImpl departmentService;
@PostMapping("/add-department")
public void addDepartment(@RequestBody Department d) {
    departmentService.addDepartment(d);
}
}
