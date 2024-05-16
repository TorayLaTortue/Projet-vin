package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.CommandeEntity;
import com.example.StockOvin.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class CommandeController {

    @Autowired
    private CommandeService CommandeService;


    @GetMapping("/commande")
    public List<CommandeEntity> getAllCommande() {
        return CommandeService.getAllCommande();
    }

}