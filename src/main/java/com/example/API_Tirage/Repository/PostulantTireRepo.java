package com.example.API_Tirage.Repository;

import com.example.API_Tirage.Model.PostulantTire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PostulantTireRepo extends JpaRepository<PostulantTire,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant_tire(id_post,nom_postulant,prenom_postulant,numero_postulant,email_postulant,id_tirage) values(?,?,?,?,?,?)", nativeQuery=true)
  public  int INSERTPOSTTIRE(Long idPost, String nomPostulant,String PrenomPostulant,String numeroPostulant,String emailPostulant, Long id_tirage);


    @Query(value = "SELECT * from postulant_tire",nativeQuery = true)
    Iterable<Object[]> RequetteAfficherPsTr();
}

