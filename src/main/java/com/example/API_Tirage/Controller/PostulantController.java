package com.example.API_Tirage.Controller;

import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostulantController {
    private PostulantService LPS;

    @PostMapping("/importation")
    public String Importer(Postulants postulants){
        LPS.ImportDonner(postulants);
        return "Importer avec succes";
    }





}
