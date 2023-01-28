package com.esprit.kaddem.entites;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartment", nullable = false)
    private Long idDepartment;

    private String nameDepartment;


}
