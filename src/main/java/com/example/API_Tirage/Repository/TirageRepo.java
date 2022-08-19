package com.example.API_Tirage.Repository;

import com.example.API_Tirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TirageRepo extends JpaRepository<Tirage,Long> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM postulants ORDER BY RAND() LIMIT 5", nativeQuery=true)
    Iterable<Object[]> TirageMethod();
}
