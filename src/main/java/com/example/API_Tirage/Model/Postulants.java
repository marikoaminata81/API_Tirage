package com.example.API_Tirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Postulants")
@Getter
@Setter
public class Postulants {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idPost;
    private long numero;
    private  String nom,prenom,email;

    @ManyToMany
    private Liste_Postulant liste_postulant;

}
