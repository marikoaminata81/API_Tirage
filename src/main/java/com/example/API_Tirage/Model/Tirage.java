package com.example.API_Tirage.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tirage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idTirage;
    private String libelletirage;
    private Date dateTirage;

    @ManyToOne
    @JoinColumn(name = "liste_postulant_id_liste_postulant")
    private  ListePostulant listePostulant;
}
