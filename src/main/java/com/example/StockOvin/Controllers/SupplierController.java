package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AddressEntity;
import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Entities.SupplierEntity;
import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.AddressService;
import com.example.StockOvin.Service.ClientService;
import com.example.StockOvin.Service.SupplierService;
import com.example.StockOvin.Service.WineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private WineService wineService;
    @Autowired
    private ClientService clientService;

    @Operation(summary = "All supplier")
    @GetMapping("/All")
    public List<SupplierEntity> getAllSuppliers() {
        return supplierService.getAllSupplier();
    }

    @Operation(summary = "New supplier (name, adress client and wine)")
    @PostMapping("/New")
    public SupplierEntity newSupplier(
            @Parameter(description = "Supplier name") @RequestParam String name,
            @Parameter(description = "Wine reference") @RequestParam int wine_reference,
            @Parameter(description = "Client reference") @RequestParam int client_reference,
            @Parameter(description = "Address reference") @RequestParam int address_reference) {

        SupplierEntity supplier = new SupplierEntity();
        AddressEntity address = addressService.getAddressById(address_reference);
        ClientEntity client = clientService.getClientById(client_reference);
        WineEntity wine = wineService.getWineById(wine_reference);

        supplier.setName(name);
        supplier.setWineReference(wine);
        supplier.setAddress(address);
        supplier.setClientReference(client);
        return supplierService.addSupplier(supplier);
    }

    @Operation(summary = "Update of a supplier (Name, first_name, email, phone)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<SupplierEntity> updateSupplier(
            @PathVariable int id,
            @Parameter(description = "Supplier name") @RequestParam String name,
            @Parameter(description = "Wine reference") @RequestParam int wine_reference,
            @Parameter(description = "Address reference") @RequestParam int address_reference,
            @Parameter(description = "New OrderCreationDate") @RequestParam Date orderCreationDate,
            @Parameter(description = "Client reference") @RequestParam int client_reference) {

        AddressEntity address = addressService.getAddressById(address_reference);
        WineEntity wine = wineService.getWineById(wine_reference);
        SupplierEntity supplier = supplierService.getSupplierById(id);
        ClientEntity client = clientService.getClientById(client_reference);
        if (supplier != null) {
            supplier.setName(name);
            supplier.setAddress(address);
            supplier.setWineReference(wine);
            supplier.setClientReference(client);

            SupplierEntity updatedSupplier = supplierService.updateSupplier(supplier);

            if (updatedSupplier != null) {
                return ResponseEntity.ok(updatedSupplier); // La mise à jour a réussi, renvoie le Fournisseur mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Fournisseur est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete supplier")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<SupplierEntity> deleteSupplier(@PathVariable("id") int reference) {
        SupplierEntity Supplier = supplierService.getSupplierById(reference);
        if (Supplier != null) {

            long currentTimeMillis = System.currentTimeMillis();

            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Supplier.setDeletionDate(date);

            SupplierEntity updatedSupplier = supplierService.updateSupplier(Supplier);

            if (updatedSupplier != null) {
                return ResponseEntity.ok(updatedSupplier); // La mise à jour a réussi, renvoie le supplier mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le supplier est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

}
