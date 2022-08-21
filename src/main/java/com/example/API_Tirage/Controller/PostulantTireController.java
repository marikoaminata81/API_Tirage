package com.example.API_Tirage.Controller;

import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Model.Tirage;
import com.example.API_Tirage.Service.PostulantTireService;
import com.example.API_Tirage.Service.TirageInterface;
import com.example.API_Tirage.Service.TirageServImple;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;

public class PostulantTireController {

    private PostulantTireService pts;
    private TirageServImple tsi;

   /* @GetMapping("/tirer")
    public  Iterable<Object[]>  Tirage(){
        return pts.TirageMethod();

    }*/

  /*  public String Importer(Tirage tirage, String libelle){
  //      ArrayList<Postulants> importer = postulantService.ImportDonner(file);

        tirage.setDateTirage(new Date());
        Tirage l = tsi.CreerTirage(tirage);

    /*    for (Postulants p: importer)
        {
            p.setIdListePostulant(l);
            postulantService.creerPostulants(p);
        }
        postulantService.ImportDonner(file);
        return "Importer avec succes";
    }*/
}
