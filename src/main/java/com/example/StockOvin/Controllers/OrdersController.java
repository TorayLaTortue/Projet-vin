package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.OrdersEntity;
import com.example.StockOvin.Service.OrdersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Orders")
public class OrdersController {

    @Autowired
    private OrdersService OrdersService;

    @Operation(summary = "Get all orders")
    @GetMapping("/All")
    public List<OrdersEntity> getAllOrders() {
        return OrdersService.getAllOrders();
    }

    @Operation(summary = "Create an order with client ref, billing address, delivery adress, wine ref and quantity product")
    @PostMapping("/New")
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
        return OrdersService.createOrders(order);
    }

    @Operation(summary = "Update an order (client ref, billing address, delivery adress, wine ref and quantity product)")
    @PutMapping("/Update/{Order}")
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
        return OrdersService.updateOrders(order);
    }

     @Operation(summary = "Delete order")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<OrdersEntity> deleteOrders(@PathVariable("id") int reference) {
        OrdersEntity Orders = OrdersService.getOrdersById(reference);
        if (Orders != null) {

            Orders.setStatus("deleted");

            OrdersEntity updatedOrders = OrdersService.updateOrders(Orders);
            
            if (updatedOrders != null) {
                return ResponseEntity.ok(updatedOrders); // La mise à jour a réussi, renvoie le Orders mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Orders est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

}
