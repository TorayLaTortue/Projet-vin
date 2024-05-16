package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.UpdateCommandeEntity;
import com.example.StockOvin.Service.UpdateCommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commande")
public class UpdateCommandeController {

    @Autowired
    private UpdateCommandeService updateCommandeService;

    @Operation(summary = "Modifier une commande existante")
    @PutMapping("/{reference_commande}")
    public UpdateCommandeEntity updateCommande(
            @PathVariable("reference_commande") Integer referenceCommande,
            @Parameter(description = "Référence du client") @RequestParam(required = false) Integer reference_client,
            @Parameter(description = "Référence de l'adresse de facturation") @RequestParam(required = false) Integer adresse_facturation,
            @Parameter(description = "Référence de l'adresse de livraison") @RequestParam(required = false) Integer adresse_livraison,
            @Parameter(description = "Référence du vin") @RequestParam(required = false) Integer reference_vin,
            @Parameter(description = "Quantité de produit") @RequestParam(required = false) Integer quantite_produit
    ) {
        return updateCommandeService.updateCommande(referenceCommande, reference_client, adresse_facturation, adresse_livraison, reference_vin, quantite_produit);
    }
}
