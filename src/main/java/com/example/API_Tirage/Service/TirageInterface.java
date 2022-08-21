package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Model.Tirage;

import java.util.List;

public interface TirageInterface {

    //Iterable<Object[]> TirageMethod();

    Tirage modifierTirage(Long idTirage,Tirage tirage);
    List<Postulants> CreerTirage(Tirage tirage, List<Postulants> listAtrier,long nbre);

    Tirage trouverTirageParLibelle(String libelletirage);
}

