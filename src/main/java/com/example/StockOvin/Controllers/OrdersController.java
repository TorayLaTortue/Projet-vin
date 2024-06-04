package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AddressEntity;
import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Entities.OrdersEntity;
import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.AddressService;
import com.example.StockOvin.Service.ClientService;
import com.example.StockOvin.Service.OrdersService;
import com.example.StockOvin.Service.WineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Orders")
public class OrdersController {

    @Autowired
    private OrdersService OrdersService;
    @Autowired
    private AddressService AddressService;
    @Autowired
    private WineService WineService;
    @Autowired
    private ClientService ClientService;

    @Operation(summary = "Get all orders")
    @GetMapping("/All")
    public List<OrdersEntity> getAllOrders() {
        return OrdersService.getAllOrders();
    }

    @Operation(summary = "Create an order with client ref, billing address, delivery adress, wine ref and quantity product")
    @PostMapping("/New")
    public OrdersEntity createOrder(
            @Parameter(description = "Client reference") @RequestParam int client_reference,
            @Parameter(description = "Billing address") @RequestParam int billing_address,
            @Parameter(description = "Delivery address") @RequestParam int delivery_address,
            @Parameter(description = "Wine Reference") @RequestParam int wine_reference,
            @Parameter(description = "Quantity of product") @RequestParam Integer quantity_product) {
        OrdersEntity order = new OrdersEntity();
        AddressEntity addressBilling = AddressService.getAddressById(billing_address);
        AddressEntity addressDilivery = AddressService.getAddressById(delivery_address);
        ClientEntity client = ClientService.getClientById(client_reference);
        WineEntity wine = WineService.getWineById(wine_reference);

        order.setClientReference(client);
        order.setBillingAddress(addressBilling);
        order.setDeliveryAddress(addressDilivery);
        order.setWineReference(wine);
        order.setQuantityProduct(quantity_product);
        // Ajouter la date de création automatique et définir le status par défaut
        order.setOrderCreationDate(LocalDate.now());
        order.setStatus("en cours");
        return OrdersService.createOrders(order);
    }

    @Operation(summary = "Update an order (client ref, billing address, delivery adress, wine ref and quantity product)")
    @PutMapping("/Update/{id}")
    public OrdersEntity updateOrders(
            @Parameter(description = "Reference de la commande à mettre à jour", required = true)
            @PathVariable("id") int orderReference,
            @Parameter(description = "Client reference") @RequestParam int client_reference,
            @Parameter(description = "Billing address") @RequestParam int billing_address,
            @Parameter(description = "Delivery address") @RequestParam int delivery_address,
            @Parameter(description = "Wine Reference") @RequestParam int wine_reference,
            @Parameter(description = "Quantity of product") @RequestParam Integer quantity_product) {
        OrdersEntity order = OrdersService.getOrdersById(orderReference);
        AddressEntity addressBilling = AddressService.getAddressById(billing_address);
        AddressEntity addressDilivery = AddressService.getAddressById(delivery_address);
        ClientEntity client = ClientService.getClientById(client_reference);
        WineEntity wine = WineService.getWineById(wine_reference);

        order.setClientReference(client);
        order.setBillingAddress(addressBilling);
        order.setDeliveryAddress(addressDilivery);
        order.setWineReference(wine);
        order.setQuantityProduct(quantity_product);
        // Mettre à jour la date de commande et le statut par défaut
        order.setOrderCreationDate(LocalDate.now());
        order.setStatus("en cours");
        return OrdersService.updateOrders(order);
    }

    @Operation(summary = "Update an order status")
    @PutMapping("/Status/{id}")
    public OrdersEntity updateStatus(
            @Parameter(description = "Reference de la commande à mettre à jour", required = true)
            @PathVariable("id") int orderReference,
            @Parameter(description = "Status") @RequestParam String status) {
        OrdersEntity order = OrdersService.getOrdersById(orderReference);

        order.setStatus(status);
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
