package com.example.API_Tirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Tirage")
@Getter
@Setter
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idTirage;
    private String libelleTirage;
    private long dateTirage;
}
