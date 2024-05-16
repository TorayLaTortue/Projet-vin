package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AdresseEntity;
import com.example.StockOvin.Service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class AdresseController {

    @Autowired
    private AdresseService AdresseService;


    @GetMapping("/adresse")
    public List<AdresseEntity> getAllDepot() {
        return AdresseService.getAllAdresse();
    }

}