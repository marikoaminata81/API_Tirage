package com.example.API_Tirage.Controller;


import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Model.Tirage;
import com.example.API_Tirage.Service.ListePostulantService;
import com.example.API_Tirage.Service.PostulantService;
import com.example.API_Tirage.Service.PostulantTireService;
import com.example.API_Tirage.Service.TirageInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tirage")
@AllArgsConstructor
public class TirageController {
    private final ListePostulantService listePostulantService;

    private final TirageInterface tirageInterface;
    private final PostulantService postulantService;
    private final PostulantTireService postulantTireService;

    @PostMapping("/creerTirage/{libelle}/{nombre}")
    public String create(@RequestBody Tirage tirage, @PathVariable String libelle, @PathVariable Long nombre,ListePostulant listeP) {

if(tirageInterface.trouverTirageParLibelle(tirage.getLibelletirage())==null) {

    ListePostulant liste = listePostulantService.trouverListeParLibelle(libelle);

    List<Postulants> postulant = postulantService.TrouveridPostList(liste.getIdListePostulant());

    List<Postulants> lp = tirageInterface.CreerTirage(tirage, postulant, nombre);

    Long idTirage = tirageInterface.trouverTirageParLibelle(tirage.getLibelletirage()).getIdTirage();
    //ListePostulant l = listePostulantService.CreerListe(listeP);
    for (Postulants p : lp) {
        //  p.setIdListePostulant(l);
        postulantTireService.creer(p.getIdPost(), p.getNomPostulant(), p.getPrenomPostulant(), p.getNumeroPostulant(), p.getEmailPostulant(), idTirage);

    }
}
else{
    return "Tirage existant";
}


        return "succes";
    }


    @PutMapping("/modifierTirage/{idTirage}")
    public Tirage modifer(@PathVariable Long idTirage, @RequestBody Tirage tirage) {
        return tirageInterface.modifierTirage(idTirage, tirage);


    }
}
