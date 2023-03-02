package com.esprit.kaddem.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Etudiant")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option op;
    // Constructeur et accesseurs (getters) et mutateurs (setters)
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;
    @ManyToOne
    private Department department;
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private List<Equipe> equipes;
}
