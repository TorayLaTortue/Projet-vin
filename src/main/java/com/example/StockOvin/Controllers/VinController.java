package com.example.StockOvin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.StockOvin.Entities.VinEntity;
import com.example.StockOvin.Service.VinService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/getAllVins")
@CrossOrigin(origins = "http://127.0.0.1:8081")
public class VinController {

    @Autowired
    private VinService vinService;

    @GetMapping
    public List<VinEntity> getAllVins() {
        return vinService.getAllVins();
    }
}