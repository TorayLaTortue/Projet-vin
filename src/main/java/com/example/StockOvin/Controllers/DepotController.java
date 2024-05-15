package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.DepotEntity;
import com.example.StockOvin.Service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class DepotController {

    @Autowired
    private DepotService DepotService;


    @GetMapping("/dépôt")
    public List<DepotEntity> getAllDepot() {
        return DepotService.getAllDepot();
    }

}