package com.example.API_Tirage.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PostilantTS")
@Getter
@Setter
public class PostilantTS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPostulant;

    @ManyToOne
    @JoinColumn(name = "tirage_id_tirage")
    private Tirage tirage;
}
