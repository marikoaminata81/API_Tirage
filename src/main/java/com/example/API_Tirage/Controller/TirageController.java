package com.example.API_Tirage.Controller;


import com.example.API_Tirage.Service.TirageInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tirage")
@AllArgsConstructor
public class TirageController {
    private  TirageInterface tirIn;

    @GetMapping("/tirer")
    public  Iterable<Object[]>  Tirage(){
        return tirIn.TirageMethod();

    }
}
