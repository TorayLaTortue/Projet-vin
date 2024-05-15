package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Service.ClientService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClient();
    }

    @Operation(summary = "Nouveau client")
    @PostMapping("/newClient")
    public ClientEntity newClient(@RequestBody ClientEntity newClient) {
        ClientEntity client = new ClientEntity();
        client.setNom(newClient.getNom());
        client.setPrenom(newClient.getPrenom());
        client.setMail(newClient.getMail());
        client.setTelephone(newClient.getTelephone());
        client.setMotdepasse(newClient.getMotdepasse());
        client.setRole("Client");
        return clientService.AddClient(client);
    }
}
