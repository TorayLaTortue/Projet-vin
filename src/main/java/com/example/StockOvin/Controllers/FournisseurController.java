package com.example.StockOvin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.StockOvin.Entities.FournisseurEntity;
import com.example.StockOvin.Service.FournisseurService;

@RestController
@RequestMapping("/getAllFournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<FournisseurEntity> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();

    }
}