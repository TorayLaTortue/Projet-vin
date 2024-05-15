package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Models.ClientModels;
import com.example.StockOvin.Service.ClientService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class ClientController {

    @Autowired
    private ClientService ClientService;


    @GetMapping("/client")
    public List<ClientEntity> getAllClient() {
        return ClientService.getAllClient();
    }

    @Operation(summary = "Nouveau client")
    @PostMapping("/newClient")
    public ClientEntity newClient(@RequestBody ClientModels newClient) {
        ClientEntity Client = new ClientEntity();
        Client.setNom(newClient.getNom());
        Client.setPrenom(newClient.getPrenom());
        Client.setMail(newClient.getMail());
        Client.setTelephone(newClient.getTelephone());
        Client.setRole("Client");
        return ClientService.AddClient(Client);
    }

}