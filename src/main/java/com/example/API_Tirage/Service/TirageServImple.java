package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Model.Tirage;
import com.example.API_Tirage.Repository.TirageRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TirageServImple implements TirageInterface{
   private  TirageRepo tireRep;



   // mOdifier la tirage
   @Override
   public Tirage modifierTirage(Long idTirage, Tirage tirage) {
      return tireRep.findById(idTirage).map(
              p->{
                 p.setDateTirage(tirage.getDateTirage());
                 p.setLibelletirage(tirage.getLibelletirage());
                 p.setListePostulant(tirage.getListePostulant());

                 return tireRep.save(p);
              }
      ).orElseThrow(() -> new RuntimeException("Tirage non trouver"));
   }

   @Override
   public List<Postulants> CreerTirage(Tirage tirage, List<Postulants> listAtrier, long nbre) {

      Random rand = new Random();
      List<Postulants> list = new ArrayList<>();
      for(int i=0; i<nbre;i++){
         Integer idAct = rand.nextInt(listAtrier.size());
         list.add(listAtrier.get(idAct));
         listAtrier.remove(listAtrier.get(idAct));
      }
      tireRep.save(tirage);
      return list;
   }

   @Override
   public Tirage trouverTirageParLibelle(String libelle) {
      return tireRep.findByLibelletirage(libelle);
   }
}
