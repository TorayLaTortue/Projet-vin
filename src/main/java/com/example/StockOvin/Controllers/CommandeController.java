package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.CommandeEntity;
import com.example.StockOvin.Service.CommandeService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService CommandeService;

    @Autowired
    private CommandeService commandeService;

    @Operation(summary = "Créer une commande")
    @PostMapping
    public CommandeEntity createCommande(
            @Parameter(description = "Référence du client") @RequestParam Long referenceClient,
            @Parameter(description = "Adresse de facturation") @RequestParam Long adresseFacturation,
            @Parameter(description = "Adresse de livraison") @RequestParam Long adresseLivraison,
            @Parameter(description = "Référence du vin") @RequestParam Long referenceVin,
            @Parameter(description = "Quantité de produit") @RequestParam Integer quantiteProduit) {
        CommandeEntity commande = new CommandeEntity();
        commande.setReferenceClient(referenceClient);
        commande.setAdresseFacturation(adresseFacturation);
        commande.setAdresseLivraison(adresseLivraison);
        commande.setReferenceVin(referenceVin);
        commande.setQuantiteProduit(quantiteProduit);
        // Ajouter la date de création automatique et définir le statut par défaut
        commande.setDateCreationCommande(LocalDate.now());
        commande.setStatut("en cours");
        return CommandeService.createCommande(commande);
    }

    @Operation(summary = "Mettre à jour une commande")
    @PutMapping("/{referenceCommande}")
    public CommandeEntity updateCommande(
            @Parameter(description = "Référence de la commande à mettre à jour", required = true)
            @PathVariable Long referenceCommande,
            @Parameter(description = "Référence du client") @RequestParam Long referenceClient,
            @Parameter(description = "Adresse de facturation") @RequestParam Long adresseFacturation,
            @Parameter(description = "Adresse de livraison") @RequestParam Long adresseLivraison,
            @Parameter(description = "Référence du vin") @RequestParam Long referenceVin,
            @Parameter(description = "Quantité de produit") @RequestParam Integer quantiteProduit) {
        CommandeEntity commande = new CommandeEntity();
        commande.setReferenceCommande(referenceCommande);
        commande.setReferenceClient(referenceClient);
        commande.setAdresseFacturation(adresseFacturation);
        commande.setAdresseLivraison(adresseLivraison);
        commande.setReferenceVin(referenceVin);
        commande.setQuantiteProduit(quantiteProduit);
        // Ajouter la date de création automatique et définir le statut par défaut
        commande.setDateCreationCommande(LocalDate.now());
        commande.setStatut("en cours");
        return CommandeService.updateCommande(commande);
    }

    @Operation(summary = "Obtenir toutes les commandes")
    @GetMapping
    public List<CommandeEntity> getAllCommandes() {
        return CommandeService.getAllCommande();
    }


}
