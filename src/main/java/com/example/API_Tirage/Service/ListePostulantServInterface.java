package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Tirage;

public interface ListePostulantServInterface {

    ListePostulant CreerListe(ListePostulant listePostulant);

    ListePostulant trouverListeParLibelle(String libelle);
}
