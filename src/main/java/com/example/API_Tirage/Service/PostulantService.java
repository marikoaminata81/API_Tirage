package com.example.API_Tirage.Service;

import com.example.API_Tirage.Model.Postulants;
import com.example.API_Tirage.Repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@AllArgsConstructor
@Service
public class PostulantService implements PostulantServInter {

    @Autowired
    private  final PostulantRepo pr;

    @Override
    public ArrayList<Postulants> ImportDonner(MultipartFile file) {

        DataFormatter formatter=new DataFormatter();
        ArrayList<Postulants> values = new ArrayList<Postulants>(); // Variable permettant de prendre toutes les donnes du tableau

        // Bloque permettant de lever les exception lors de l'importation du fichier excel
        try{
            //InputStream fichier = new FileInputStream("fichierSource.xls"); // Recuperation du fichier Execl sous forme de fichier simple

            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream()); // conversion du fichier simple sous forme d'un fichier POI

            HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

            HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

            Iterator rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
            // Boucle permettant de parcours toutes lignes de la page

            while (rows.hasNext()){

                //values.clear(); // Vider toutes les donnes du tableau dynamique "values"

                HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                Iterator cells = row.cellIterator(); // Recuperation de toutes toutes les colonnes de chaque ligne
                Postulants p=new Postulants();
                int numColun=0;
                // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                while (cells.hasNext()){

                    HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                    switch (numColun){

                        case 0:
                            p.setNomPostulant(formatter.formatCellValue(cell));

                            break;
                        case 1:
                            p.setPrenomPostulant(formatter.formatCellValue(cell));
                            break;
                        case 2:
                            p.setNumeroPostulant(formatter.formatCellValue(cell));
                            break;
                        case 3:
                            p.setEmailPostulant(formatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                    numColun++;

                    // Condition permettant de verifier le type de la colonne et effectuer une convesion si c'est type int
                    // if (cell.getCellType() == CellType.NUMERIC){
                    //   values.add(Integer.toString((int) cell.getNumericCellValue()));
                    // }
                    //else{
                    //  values.add(cell.getStringCellValue());
                    // }
                }

                //postulantRepository.INSERTPOSTULANT (values.get(3),values.get(1),values.get(2),values.get(0));
                values.add(p);
            }
            return values;

        }catch (Exception e){

            e.printStackTrace();
            return null;

        }

    }

    @Override
   public Postulants creerPostulants (Postulants postulants){

        return pr.save(postulants);
    }

    @Override
    public List<Postulants> TrouveridPostList(long idListe) {
        return pr.FINDIDPOSTLIST(idListe);
    }
  /*  @Override
    public void ImportDonner(MultipartFile file) {

        ArrayList<String> values = new ArrayList<String>();

        try{
            //InputStream input = new FileInputStream("Classeur1.xls");
            POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet =wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();

            while (rows.hasNext()){
                values.clear();
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells= row.cellIterator();
                while ((cells.hasNext())){
                    HSSFCell cell =(HSSFCell) cells.next();

                    if(cell.getCellType() ==CellType.NUMERIC)
                        values.add(Integer.toString((int) cell.getNumericCellValue()));
                        else if (CellType.STRING == cell.getCellType())
                            values.add(cell.getStringCellValue());
                    }


           pr.InsertPostulant(values.get(0), values.get(1), values.get(2), values.get(3));
                }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/



}
