package com.example.API_Tirage.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Tirage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idTirage;
            private String libelleTirage;
    private  long dateTirage;
}
