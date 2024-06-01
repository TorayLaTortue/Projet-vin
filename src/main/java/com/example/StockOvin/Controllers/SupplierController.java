package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.SupplierEntity;
import com.example.StockOvin.Service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers") // Adjusted to a more RESTful naming convention
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<SupplierEntity> getAllSuppliers() { // Updated method name
        return supplierService.getAllSupplier();
    }

    @Operation(summary = "Nouveau Fournisseur")
    @PostMapping("/newFournisseur")
    public SupplierEntity newSupplier(@RequestBody SupplierEntity newSupplier) { // Updated method name
        SupplierEntity supplier = new SupplierEntity();
        supplier.setName(newSupplier.getName());
        supplier.setOrderCreationDate(newSupplier.getOrderCreationDate());
        supplier.setWineQuality(newSupplier.getWineQuality());
        supplier.setAddress(newSupplier.getAddress());
        return supplierService.addSupplier(supplier);
    }

    @Operation(summary = "Update d'un Fournisseur (Name, first_name, eMail, phone)")
    @PutMapping("/updateFournisseur/{id}")
    public ResponseEntity<SupplierEntity> updateSupplier(@PathVariable int id, @RequestBody SupplierEntity newSupplier) { // Updated method name
        SupplierEntity supplier = supplierService.getSupplierById(id);
        if (supplier != null) {
            supplier.setName(newSupplier.getName());
            supplier.setOrderCreationDate(newSupplier.getOrderCreationDate());
            supplier.setWineQuality(newSupplier.getWineQuality());
            supplier.setAddress(newSupplier.getAddress());

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
}
