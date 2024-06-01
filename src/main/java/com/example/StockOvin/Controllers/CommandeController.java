package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.OrderEntity;
import com.example.StockOvin.Service.OrderService;

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
    private OrderService orderService;

    @Operation(summary = "Créer une commande")
    @PostMapping
    public OrderEntity createCommande(
            @Parameter(description = "Client reference") @RequestParam Long clientReference,
            @Parameter(description = "Billing adress") @RequestParam Long billingAddress,
            @Parameter(description = "Delivery adress") @RequestParam Long deliveryAddress,
            @Parameter(description = "Wine Reference") @RequestParam Long wineReference,
            @Parameter(description = "Quantity of product") @RequestParam Integer quantityProduct) {
        OrderEntity order = new OrderEntity();
        order.setClientReference(clientReference);
        order.setBillingAddress(billingAddress);
        order.setDeliveryAddress(deliveryAddress);
        order.setWineReference(wineReference);
        order.setQuantityProduct(quantityProduct);
        // Ajouter la date de création automatique et définir le status par défaut
        order.setOrderCreationDate(LocalDate.now());
        order.setStatus("en cours");
        return orderService.createCommande(order);
    }

    @Operation(summary = "Mettre à jour une commande")
    @PutMapping("/{orderReference}")
    public OrderEntity updateCommande(
            @Parameter(description = "Reference de la commande à mettre à jour", required = true)
            @PathVariable Long orderReference,
            @Parameter(description = "Client reference") @RequestParam Long clientReference,
            @Parameter(description = "Billing adress") @RequestParam Long billingAddress,
            @Parameter(description = "Delivery adress") @RequestParam Long deliveryAddress,
            @Parameter(description = "Wine Reference") @RequestParam Long wineReference,
            @Parameter(description = "Quantity of product") @RequestParam Integer quantityProduct) {
        OrderEntity order = new OrderEntity();
        order.setOrderReference(orderReference);
        order.setClientReference(clientReference);
        order.setBillingAddress(billingAddress);
        order.setDeliveryAddress(deliveryAddress);
        order.setWineReference(wineReference);
        order.setQuantityProduct(quantityProduct);
        // Mettre à jour la date de commande et le statut par défaut
        order.setOrderCreationDate(LocalDate.now());
        order.setStatus("en cours");
        return orderService.updateCommande(order);
    }

    @Operation(summary = "Obtenir toutes les commandes")
    @GetMapping
    public List<OrderEntity> getAllCommandes() {
        return orderService.getAllCommande();
    }
}
