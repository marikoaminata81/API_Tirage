package com.example.API_Tirage.Repository;

import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ListePostulantRepo extends  JpaRepository<ListePostulant,Long>{
    ListePostulant findByLibelle(String libelle);
    @Query(value = "SELECT liste_postulant.libelle,liste_postulant.date_liste_postulant from liste_postulant",nativeQuery = true)
    Iterable<Object[]> RequetteAfficher();

    //nombre liste
    @Query(value = "SELECT count(liste_postulant.id_liste_postulant) from liste_postulant",nativeQuery = true)
    Long nombreliste();

}
