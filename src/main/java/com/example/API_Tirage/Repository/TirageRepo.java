package com.example.API_Tirage.Repository;

import com.example.API_Tirage.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepo extends JpaRepository<Tirage,Long> {
}
