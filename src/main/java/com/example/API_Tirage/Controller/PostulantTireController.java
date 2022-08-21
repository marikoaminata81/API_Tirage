package com.example.API_Tirage.Controller;

import com.example.API_Tirage.Model.ListePostulant;
import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Model.Tirage;
import com.example.API_Tirage.Service.PostulantTireService;
import com.example.API_Tirage.Service.TirageInterface;
import com.example.API_Tirage.Service.TirageServImple;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;


@RestController
@RequestMapping("/postulantTire")
@AllArgsConstructor
@NoArgsConstructor
public class PostulantTireController {
@Autowired
    private PostulantTireService pts;

    @GetMapping("/AffichagePostTirer")
    public   Iterable<Object[]> AfficherTousPostulants(){
        return pts.AfficherTousPostulantsTirer();
    }


}
