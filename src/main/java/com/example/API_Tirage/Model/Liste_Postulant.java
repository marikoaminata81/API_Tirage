package com.example.API_Tirage.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ListePostulant")
@Getter
@Setter
public class Liste_Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLP;
    private  long Date;
    private String libelle;
}
