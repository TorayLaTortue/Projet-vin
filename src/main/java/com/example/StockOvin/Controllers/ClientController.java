package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService ClientService;


    @GetMapping("/client")
    public List<ClientEntity> getAllClient() {
        return ClientService.getAllClient();
    }

}