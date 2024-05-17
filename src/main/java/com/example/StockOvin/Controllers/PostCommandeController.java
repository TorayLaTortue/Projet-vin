package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.PostCommandeEntity;
import com.example.StockOvin.Service.PostCommandeService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/commandes")
public class PostCommandeController {

    @Autowired
    private PostCommandeService postCommandeService;

    @Autowired
    private PostCommandeService commandeService;

    @Operation(summary = "Créer une commande")
    @PostMapping
    public PostCommandeEntity createCommande(
            @Parameter(description = "Référence du client") @RequestParam Long referenceClient,
            @Parameter(description = "Adresse de facturation") @RequestParam Long adresseFacturation,
            @Parameter(description = "Adresse de livraison") @RequestParam Long adresseLivraison,
            @Parameter(description = "Référence du vin") @RequestParam Long referenceVin,
            @Parameter(description = "Quantité de produit") @RequestParam Integer quantiteProduit) {
        PostCommandeEntity commande = new PostCommandeEntity();
        commande.setReferenceClient(referenceClient);
        commande.setAdresseFacturation(adresseFacturation);
        commande.setAdresseLivraison(adresseLivraison);
        commande.setReferenceVin(referenceVin);
        commande.setQuantiteProduit(quantiteProduit);
        // Ajouter la date de création automatique et définir le statut par défaut
        commande.setDateCreationCommande(LocalDate.now());
        commande.setStatut("en cours");
        return postCommandeService.createCommande(commande);
    }

    @Operation(summary = "Mettre à jour une commande")
    @PutMapping("/{referenceCommande}")
    public PostCommandeEntity updateCommande(
            @Parameter(description = "Référence de la commande à mettre à jour", required = true)
            @PathVariable Long referenceCommande,
            @Parameter(description = "Référence du client") @RequestParam Long referenceClient,
            @Parameter(description = "Adresse de facturation") @RequestParam Long adresseFacturation,
            @Parameter(description = "Adresse de livraison") @RequestParam Long adresseLivraison,
            @Parameter(description = "Référence du vin") @RequestParam Long referenceVin,
            @Parameter(description = "Quantité de produit") @RequestParam Integer quantiteProduit) {
        PostCommandeEntity commande = new PostCommandeEntity();
        commande.setReferenceCommande(referenceCommande);
        commande.setReferenceClient(referenceClient);
        commande.setAdresseFacturation(adresseFacturation);
        commande.setAdresseLivraison(adresseLivraison);
        commande.setReferenceVin(referenceVin);
        commande.setQuantiteProduit(quantiteProduit);
        // Ajouter la date de création automatique et définir le statut par défaut
        commande.setDateCreationCommande(LocalDate.now());
        commande.setStatut("en cours");
        return postCommandeService.updateCommande(commande);
    }

    @Operation(summary = "Obtenir toutes les commandes")
    @GetMapping
    public List<PostCommandeEntity> getAllPostCommandes() {
        return postCommandeService.getAllCommande();
    }


}
