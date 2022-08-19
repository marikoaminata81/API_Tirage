package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Postulants;

import java.util.List;

public interface PostulantServInter {
    void ImportDonner(Postulants postulants);
    List<Postulants> AfficherListe();

}
