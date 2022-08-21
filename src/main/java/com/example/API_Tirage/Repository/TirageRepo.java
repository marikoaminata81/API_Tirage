package com.example.API_Tirage.Repository;

import com.example.API_Tirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TirageRepo extends JpaRepository<Tirage,Long> {

Tirage  findByLibelletirage(String libelle);
}

