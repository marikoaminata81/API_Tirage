package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Tirage;
import com.example.API_Tirage.Repository.PostulantTireRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostulantTireImplement implements  PostulantTireService{
private final PostulantTireRepo ptr;
    /*public Iterable<Object[]> TirageMethod() {

        return ptr.TirageMethod();
    }*/

    @Override
    public int creer(Long idPostulant, String nomPostulant, String prenomPostulant, String emailPostulant, String numeroPostulant,long id_tirage) {
        return ptr.INSERTPOSTTIRE(idPostulant,nomPostulant,prenomPostulant,emailPostulant,numeroPostulant,id_tirage);
    }


}
