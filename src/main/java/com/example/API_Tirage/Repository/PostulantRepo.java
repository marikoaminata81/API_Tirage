package com.example.API_Tirage.Repository;

import com.example.API_Tirage.Model.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PostulantRepo extends JpaRepository<Postulants,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulants(nom_postulant, prenom_postulant,numero_postulant, email_postulant) value(?,?,?,?)", nativeQuery = true)
     int InsertPostulant(String nom, String prenom, String numero, String email);

   /* @Query(value = "SELECT nom_postulant, prenom_postulant FROM postulants ORDER BY RAND() LIMIT 5", nativeQuery=true)
    String Rn();*/
}
