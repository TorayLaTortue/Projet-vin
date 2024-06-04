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
@RequestMapping("/Suppliers") 
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<SupplierEntity> getAllSuppliers() {
        return supplierService.getAllSupplier();
    }

    @Operation(summary = "New supplier")
    @PostMapping("/New")
    public SupplierEntity newSupplier(@RequestBody SupplierEntity newSupplier) {
        SupplierEntity supplier = new SupplierEntity();
        supplier.setName(newSupplier.getName());
        supplier.setOrderCreationDate(newSupplier.getOrderCreationDate());
        supplier.setWineQuality(newSupplier.getWineQuality());
        supplier.setAddress(newSupplier.getAddress());
        return supplierService.addSupplier(supplier);
    }

    @Operation(summary = "Update of a supplier (Name, first_name, email, phone)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<SupplierEntity> updateSupplier(@PathVariable int id, @RequestBody SupplierEntity newSupplier) { 
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
