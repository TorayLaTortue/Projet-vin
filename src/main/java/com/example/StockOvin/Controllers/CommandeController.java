package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.OrderEntity;
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
    public OrderEntity createCommande(
            @Parameter(description = "Référence du client") @RequestParam Long referenceClient,
            @Parameter(description = "Address de facturation") @RequestParam Long addressFacturation,
            @Parameter(description = "Address de livraison") @RequestParam Long addressLivraison,
            @Parameter(description = "Référence du wine") @RequestParam Long wineReference,
            @Parameter(description = "Quantité de produit") @RequestParam Integer quantityProduit) {
        OrderEntity commande = new OrderEntity();
        commande.setReferenceClient(referenceClient);
        commande.setAddressFacturation(addressFacturation);
        commande.setAddressLivraison(addressLivraison);
        commande.setWineReference(wineReference);
        commande.setQuantityProduit(quantityProduit);
        // Ajouter la date de création automatique et définir le status par défaut
        commande.setDateCreationCommande(LocalDate.now());
        commande.setStatut("en cours");
        return CommandeService.createCommande(commande);
    }

    @Operation(summary = "Mettre à jour une commande")
    @PutMapping("/{referenceCommande}")
    public OrderEntity updateCommande(
            @Parameter(description = "Référence de la commande à mettre à jour", required = true)
            @PathVariable Long referenceCommande,
            @Parameter(description = "Référence du client") @RequestParam Long referenceClient,
            @Parameter(description = "Address de facturation") @RequestParam Long addressFacturation,
            @Parameter(description = "Address de livraison") @RequestParam Long addressLivraison,
            @Parameter(description = "Référence du wine") @RequestParam Long wineReference,
            @Parameter(description = "Quantité de produit") @RequestParam Integer quantityProduit) {
        OrderEntity commande = new OrderEntity();
        commande.setReferenceCommande(referenceCommande);
        commande.setReferenceClient(referenceClient);
        commande.setAddressFacturation(addressFacturation);
        commande.setAddressLivraison(addressLivraison);
        commande.setWineReference(wineReference);
        commande.setQuantityProduit(quantityProduit);
        // Ajouter la date de création automatique et définir le status par défaut
        commande.setDateCreationCommande(LocalDate.now());
        commande.setStatut("en cours");
        return CommandeService.updateCommande(commande);
    }

    @Operation(summary = "Obtenir toutes les commandes")
    @GetMapping
    public List<OrderEntity> getAllCommandes() {
        return CommandeService.getAllCommande();
    }


}
