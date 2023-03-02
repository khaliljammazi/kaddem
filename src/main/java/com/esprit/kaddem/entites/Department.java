package com.esprit.kaddem.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartment", nullable = false)
    private int idDepartment;

    private String nameDepartment;

    @OneToMany(mappedBy = "department")
    private List<Etudiant> etudiants1;

    @ManyToOne (cascade = CascadeType.ALL)
    @JsonIgnore
    private Universite university;

}
