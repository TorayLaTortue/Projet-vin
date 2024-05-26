package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Service.ClientService;

import io.swagger.v3.oas.annotations.Operation;
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
    public ClientEntity newClient(@RequestBody ClientEntity newClient) {
        ClientEntity Client = new ClientEntity();
        Client.setName(newClient.getName());
        Client.setFirstName(newClient.getFirstName());
        Client.seteMail(newClient.geteMail());
        Client.setPhone(newClient.getPhone());
        Client.setMot_de_passe(newClient.getMot_de_passe());
        Client.setRole("Client");
        return ClientService.AddClient(Client);
    }

    @Operation(summary = "Update d'un client (Name ,first_name ,eMail ,phone)")
    @PutMapping("/Update{id}")
    public ResponseEntity<ClientEntity> updateClient(int reference, @RequestBody ClientEntity newClient) {
        ClientEntity Client = ClientService.getClientById(reference);
        if (Client != null) {
            Client.setName(newClient.getName());
            Client.setFirstName(newClient.getFirstName());
            Client.seteMail(newClient.geteMail());
            Client.setPhone(newClient.getPhone());

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
    public ResponseEntity<ClientEntity> updateMdpClient(@PathVariable("id") int reference, @RequestBody ClientEntity newClient) {
        ClientEntity Client = ClientService.getClientById(reference);
        if (Client != null) {
            Client.setMot_de_passe(newClient.getMot_de_passe());

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

            Client.setDate_suppression(date); // Utilisez la méthode setMotDePasse au lieu de setmotDePasse

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