package com.example.API_Tirage.Service;


import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Tirage;
import com.example.API_Tirage.Repository.ListePostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListePostulantService implements ListePostulantServInterface{

    private  final ListePostulantRepo listePostulantRepo;
    @Override
    public ListePostulant CreerListe(ListePostulant listePostulant) {

        return listePostulantRepo.save(listePostulant);
    }

    //fonctio rechercher toutes les listes
    @Override
    public Iterable<Object[]> AfficherTouteslistes() {
        return listePostulantRepo.RequetteAfficher();
    }

    @Override
    public Long NombreTotalListe() {
        return listePostulantRepo.nombreliste();
    }

    @Override
    public ListePostulant trouverListeParLibelle(String libelle) {

        return listePostulantRepo.findByLibelle(libelle);
    }
}
