package com.example.API_Tirage.Controller;

import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Service.ListePostulantService;
import com.example.API_Tirage.Service.PostulantService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/postulant")
@AllArgsConstructor
@NoArgsConstructor
public class PostulantController {
    @Autowired
    private PostulantService postulantService;

    @Autowired
    private ListePostulantService listePostulantService;

    @PostMapping("/importation/{libelle}")
    public String Importer(@Param("file") MultipartFile file, ListePostulant liste, String libelle){
        ArrayList<Postulants> importer = postulantService.ImportDonner(file);

        liste.setDateListePostulant(new Date());
        ListePostulant l = listePostulantService.CreerListe(liste);

        for (Postulants p: importer)
        {
            p.setIdListePostulant(l);
            postulantService.creerPostulants(p);
        }
        postulantService.ImportDonner(file);

        return "Importer avec succes";
    }





}
