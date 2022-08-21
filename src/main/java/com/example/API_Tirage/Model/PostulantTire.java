package com.example.API_Tirage.Model;

import javax.persistence.*;

@Entity
@Table(name = "PostulantTire")
public class PostulantTire {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String nomPostulant;
    private String prenomPostulant;
    private String numeroPostulant;
    private String emailPostulant;

    @ManyToOne
    @JoinColumn(name = "id_tirage")
    private Tirage tirage;


}
