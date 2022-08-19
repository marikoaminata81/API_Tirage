package com.example.API_Tirage.Controller;

import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Service.ListePostulantService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostulantController {
    private ListePostulantService LPS;

    @PostMapping("/importation")
    public String Importer(Postulants postulants){
        LPS.ImportDonner(postulants);
        return "Importer avec succes";
    }




}
