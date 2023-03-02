package com.esprit.kaddem.entites;

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
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniv", nullable = false)
    private Long idUnive;
private String nomUniversite;

@OneToMany(mappedBy = "university",cascade = CascadeType.ALL)
private List<Department> departments;


}
