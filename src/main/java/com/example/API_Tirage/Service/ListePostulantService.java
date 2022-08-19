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
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@AllArgsConstructor
@Service
public class ListePostulantService implements ListePostulantServInter {

private  final PostulantRepo pr;
    @Override
    public void ImportDonner(Postulants postulants) {

        ArrayList<String> values = new ArrayList<String>();

        try{
            InputStream input = new FileInputStream("Classeur1.xls");
            POIFSFileSystem fs = new POIFSFileSystem(input);
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
    }

    @Override
    public List<Postulants> AfficherListe() {
        return pr.findAll();
    }
}
