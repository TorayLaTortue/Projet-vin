package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AdresseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.StockOvin.Entities.PostCommandeEntity;
import com.example.StockOvin.Service.PostCommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


@RestController
@RequestMapping("/")
public class PostCommandeController {

    @Autowired
    private PostCommandeService postCommandeService;

    @Operation(summary = "Créer une nouvelle commande")
    @PostMapping("/nouvelleCommande")
    public PostCommandeEntity createCommande(
            @Parameter(description = "Référence du client") @RequestParam(required = false) int referenceClient,
            @Parameter(description = "Référence de l'adresse de facturation") @RequestParam(required = false) AdresseEntity referenceAdresseFacturation,
            @Parameter(description = "Référence de l'adresse de livraison") @RequestParam(required = false) AdresseEntity referenceAdresseLivraison,
            @Parameter(description = "Référence du vin") @RequestParam(required = false) int referenceVin,
            @Parameter(description = "Quantité de produit") @RequestParam(required = false) int quantiteProduit
    ) {

        PostCommandeEntity commande = new PostCommandeEntity();

        commande.setReferenceClient(referenceClient);
        commande.setAdresseFacturation(referenceAdresseFacturation);
        commande.setAdresseLivraison(referenceAdresseLivraison);
        commande.setReferenceVin(referenceVin);
        commande.setQuantiteProduit(quantiteProduit);


        return postCommandeService.createCommande(commande);

    }
}
