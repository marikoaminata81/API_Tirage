package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Postulants;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface PostulantServInter {


    //void ImportDonner( MultipartFile file);
    ArrayList<Postulants> ImportDonner(MultipartFile file);
    //void ImportDonner(MultipartFile file, Postulants postulants);
    Postulants creerPostulants (Postulants postulants);

List<Postulants> TrouveridPostList(long idListe);
}
