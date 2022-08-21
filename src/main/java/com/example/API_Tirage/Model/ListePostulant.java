package com.example.API_Tirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ListePostulant")
@Setter
@Getter
public class ListePostulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListePostulant;
    private Date dateListePostulant;
    private String libelle;
}
