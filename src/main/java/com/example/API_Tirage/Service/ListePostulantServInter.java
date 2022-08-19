package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.PostulantTire;
import com.example.API_Tirage.Model.Postulants;

import java.util.List;

public interface ListePostulantServInter {
    void ImportDonner(Postulants postulants);
    List<Postulants> AfficherListe();

}
