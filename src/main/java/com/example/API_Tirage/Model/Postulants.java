package com.example.API_Tirage.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Postulants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idPost;
    private  String nomPostulant,prenomPostulant,emailPostulant;
    private  String numeroPostulant;

    @ManyToOne
    @JoinColumn(name = "id_liste_postulant")
    private ListePostulant idListePostulant;
}
