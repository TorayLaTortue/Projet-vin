package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AddressEntity;
import com.example.StockOvin.Entities.SupplierEntity;
import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.AddressService;
import com.example.StockOvin.Service.SupplierService;
import com.example.StockOvin.Service.WineService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/Supplier") 
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private AddressService AddressService;
    @Autowired
    private WineService WineService;

    @Operation(summary =  "All supplier")
    @GetMapping("/All")
    public List<SupplierEntity> getAllSuppliers() {
        return supplierService.getAllSupplier();
    }

    @Operation(summary = "New supplier (name, adress and wine)")
    @PostMapping("/New/{address_reference}/{wine_reference}")
    public SupplierEntity newSupplier(@RequestBody SupplierEntity newSupplier, @PathVariable("address_reference") int address_reference, @PathVariable("wine_reference") int wine_reference) {
        SupplierEntity supplier = new SupplierEntity();
        AddressEntity address = AddressService.getAddressById(address_reference);
        WineEntity wine = WineService.getWineById(wine_reference);
        Date date = new Date(System.currentTimeMillis());

        supplier.setName(newSupplier.getName());
        supplier.setOrderCreationDate(date);
        supplier.setWine_reference(wine);
        supplier.setAddress(address);
        return supplierService.addSupplier(supplier);
    }

    @Operation(summary = "Update of a supplier (Name, first_name, email, phone)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<SupplierEntity> updateSupplier(@PathVariable int id, @RequestBody SupplierEntity newSupplier) { 
        SupplierEntity supplier = supplierService.getSupplierById(id);
        if (supplier != null) {
            supplier.setName(newSupplier.getName());
            supplier.setOrderCreationDate(newSupplier.getOrderCreationDate());
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
