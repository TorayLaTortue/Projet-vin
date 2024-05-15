package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.ClientEntity;
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

    @Operation(summary = "Liste de toutes les infos de tout les clients")
    @GetMapping("/client")
    public List<ClientEntity> getAllClient() {
        return ClientService.getAllClient();
    }

    @Operation(summary = "Nouveau client")
    @PostMapping("/newClient")
    public ClientEntity newClient(@RequestBody ClientEntity newClient) {
        ClientEntity Client = new ClientEntity();
        Client.setNom(newClient.getNom());
        Client.setPrenom(newClient.getPrenom());
        Client.setMail(newClient.getMail());
        Client.setTelephone(newClient.getTelephone());
        Client.setRole("Client");
        return ClientService.AddClient(Client);
    }

    @Operation(summary = "Update d'un client (Nom ,prenom ,mail ,telephone)")
    @PutMapping("/updateClient{id}")
    public ClientEntity updateClient(int reference, @RequestBody ClientEntity newClient) {
        ClientEntity Client = ClientService.getClientById(reference);
        if (Client != null) {
        Client.setNom(newClient.getNom());
        Client.setPrenom(newClient.getPrenom());
        Client.setMail(newClient.getMail());
        Client.setTelephone(newClient.getTelephone());

        return ClientService.updateClient(Client);
        
        }
        else{
            System.out.println("Client inexistant");
            return null;
        }

    }

    @Operation(summary = "Update le mdp d'un client")
    @PutMapping("/updateClientMdp{id}")
    public ClientEntity updateMdpClient(int reference, @RequestBody ClientEntity newClient) {
        ClientEntity Client = ClientService.getClientById(reference);
        if (Client != null) {
        Client.setMotDePasse(newClient.getMotDePasse());

        return ClientService.updateClient(Client);
        
        }
        else{
            System.out.println("Client inexistant");
            return null;
        }

    }

}