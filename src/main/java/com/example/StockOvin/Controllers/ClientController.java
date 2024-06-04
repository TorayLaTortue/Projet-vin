package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    private ClientService ClientService;

    @Operation(summary = "Liste de toutes les infos de tout les clients")
    @GetMapping("/All")
    public List<ClientEntity> getAllClient() {
        return ClientService.getAllClient();
    }

    @Operation(summary = "Nouveau client")
    @PostMapping("/New")
    public ClientEntity newClient(
        @Parameter(description = "Name") @RequestParam String name,
        @Parameter(description = "Firstname") @RequestParam String firstname,
        @Parameter(description = "Email") @RequestParam String email,
        @Parameter(description = "Phone number") @RequestParam String phone,
        @Parameter(description = "Password") @RequestParam String password) {
        ClientEntity Client = new ClientEntity();
        Client.setName(name);
        Client.setFirstName(firstname);
        Client.setEmail(email);
        Client.setPhone(phone);
        Client.setMot_de_passe(password);
        Client.setRole("Client");
        return ClientService.AddClient(Client);
    }

    @Operation(summary = "Update d'un client (Name ,first_name ,email ,phone)")
    @PutMapping("/Update{id}")
    public ResponseEntity<ClientEntity> updateClient(
        @PathVariable("id") int reference,
        @Parameter(description = "Name") @RequestParam String name,
        @Parameter(description = "Firstname") @RequestParam String firstname,
        @Parameter(description = "Email") @RequestParam String email,
        @Parameter(description = "Phone number") @RequestParam String phone) {
        ClientEntity Client = ClientService.getClientById(reference);

        if (Client != null) {
            Client.setName(name);
            Client.setFirstName(firstname);
            Client.setEmail(email);
            Client.setPhone(phone);

            ClientEntity updatedClient = ClientService.updateClient(Client);
            
            if (updatedClient != null) {
                return ResponseEntity.ok(updatedClient); // La mise à jour a réussi, renvoie le client mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le client est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
}

    @Operation(summary = "Update le mdp d'un client")
    @PutMapping("/UpdateMdp/{id}")
    public ResponseEntity<ClientEntity> updateMdpClient(
        @PathVariable("id") int reference,
        @Parameter(description = "Password") @RequestParam String password
        ) {
        ClientEntity Client = ClientService.getClientById(reference);
        if (Client != null) {
            Client.setMot_de_passe(password);

            ClientEntity updatedClient = ClientService.updateClient(Client);
            
            if (updatedClient != null) {
                return ResponseEntity.ok(updatedClient); // La mise à jour a réussi, renvoie le client mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le client est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Delete d'un client")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<ClientEntity> deleteClient(@PathVariable("id") int reference) {
        ClientEntity Client = ClientService.getClientById(reference);
        if (Client != null) {
        
            long currentTimeMillis = System.currentTimeMillis();
        
            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Client.setDate_suppression(date);

            ClientEntity updatedClient = ClientService.updateClient(Client);
            
            if (updatedClient != null) {
                return ResponseEntity.ok(updatedClient); // La mise à jour a réussi, renvoie le client mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le client est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }


}