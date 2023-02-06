package com.esprit.kaddem.entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartment", nullable = false)
    private Long idDepartment;

    private String nameDepartment;

    @OneToMany(mappedBy = "department")
    private List<Etudiant> etudiants1;

    @ManyToOne (cascade = CascadeType.ALL)
    private Universite university;

}
