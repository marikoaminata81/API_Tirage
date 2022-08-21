package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Tirage;
import org.springframework.stereotype.Service;

@Service
public interface PostulantTireService {
   // public Iterable<Object[]> TirageMethod() ;

int creer(Long idPostulant,String nomPostulant, String prenomPostulant,String emailPostulant,String numeroPostulant,long id_tirage);

    Iterable<Object[]> AfficherTousPostulantsTirer();
}
