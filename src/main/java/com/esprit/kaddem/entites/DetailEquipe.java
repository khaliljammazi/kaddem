package com.esprit.kaddem.entites;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_equipe", nullable = false)
    private Long idDetailEquipe;

    private String salle;
    private String thematique;

}
