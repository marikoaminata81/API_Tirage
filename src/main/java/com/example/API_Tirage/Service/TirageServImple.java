package com.example.API_Tirage.Service;

import com.example.API_Tirage.Repository.TirageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TirageServImple implements TirageInterface{
   private  TirageRepo tireRep;

    @Override
    public Iterable<Object[]> TirageMethod() {

        return tireRep.TirageMethod();
    }
}
