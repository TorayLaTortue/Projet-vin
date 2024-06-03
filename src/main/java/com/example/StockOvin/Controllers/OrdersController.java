package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.OrdersEntity;
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
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Créer une commande")
    @PostMapping
    public OrdersEntity createCommande(
            @Parameter(description = "Client reference") @RequestParam Long client_reference,
            @Parameter(description = "Billing adress") @RequestParam Long billing_address,
            @Parameter(description = "Delivery adress") @RequestParam Long delivery_address,
            @Parameter(description = "Wine Reference") @RequestParam Long wine_reference,
            @Parameter(description = "Quantity of product") @RequestParam Integer quantity_product) {
        OrdersEntity order = new OrdersEntity();
        order.setClientReference(client_reference);
        order.setBillingAddress(billing_address);
        order.setDeliveryAddress(delivery_address);
        order.setWineReference(wine_reference);
        order.setQuantityProduct(quantity_product);
        // Ajouter la date de création automatique et définir le status par défaut
        order.setOrderCreationDate(LocalDate.now());
        order.setStatus("en cours");
        return orderService.createCommande(order);
    }

    @Operation(summary = "Mettre à jour une commande")
    @PutMapping("/{orderReference}")
    public OrdersEntity updateCommande(
            @Parameter(description = "Reference de la commande à mettre à jour", required = true)
            @PathVariable Long orderReference,
            @Parameter(description = "Client reference") @RequestParam Long client_reference,
            @Parameter(description = "Billing adress") @RequestParam Long billing_address,
            @Parameter(description = "Delivery adress") @RequestParam Long delivery_address,
            @Parameter(description = "Wine Reference") @RequestParam Long wine_reference,
            @Parameter(description = "Quantity of product") @RequestParam Integer quantity_product) {
        OrdersEntity order = new OrdersEntity();
        order.setOrderReference(orderReference);
        order.setClientReference(client_reference);
        order.setBillingAddress(billing_address);
        order.setDeliveryAddress(delivery_address);
        order.setWineReference(wine_reference);
        order.setQuantityProduct(quantity_product);
        // Mettre à jour la date de commande et le statut par défaut
        order.setOrderCreationDate(LocalDate.now());
        order.setStatus("en cours");
        return orderService.updateCommande(order);
    }

    @Operation(summary = "Obtenir toutes les commandes")
    @GetMapping
    public List<OrdersEntity> getAllCommandes() {
        return orderService.getAllCommande();
    }
}
