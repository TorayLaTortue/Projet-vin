package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AddressEntity;
import com.example.StockOvin.Entities.DepositEntity;
import com.example.StockOvin.Entities.SupplierEntity;
import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.AddressService;
import com.example.StockOvin.Service.DepositService;
import com.example.StockOvin.Service.WineService;
import com.example.StockOvin.Service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Deposit")
public class DepositController {

    @Autowired
    private DepositService DepositService;

    @Autowired
    private WineService WineService;
    @Autowired
    private AddressService AddressService;
    @Autowired
    private SupplierService SupplierService;
    


    @GetMapping("/All")
    public List<DepositEntity> getAllDeposit() {
        return DepositService.getAllDeposit();
    }

    @Operation(summary = "Substract a number of wine from a deposit")
    @PutMapping("/SubQuantity/{id}/{substract}")
    public ResponseEntity<DepositEntity> reductionDeposit(@PathVariable("id") int reference, @PathVariable("substract") int modification) {
        DepositEntity Deposit = DepositService.getDepositById(reference);
        if (Deposit != null) {
            
            Deposit.setQuantity(Deposit.getQuantity() - modification);

            DepositEntity updatedDeposit = DepositService.updateDeposit(Deposit);
            
            if (updatedDeposit != null) {
                return ResponseEntity.ok(updatedDeposit); // La mise à jour a réussi, renvoie le Deposit mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Deposit est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Add a number of wine into a deposit")
    @PutMapping("/AddQuantity/{id}/{add}")
    public ResponseEntity<DepositEntity> ajouterpDeposit(@PathVariable("id") int reference, @PathVariable("add") int modification) {
        DepositEntity Deposit = DepositService.getDepositById(reference);
        if (Deposit != null) {
            
            Deposit.setQuantity(Deposit.getQuantity() + modification);

            DepositEntity updatedDeposit = DepositService.updateDeposit(Deposit);
            
            if (updatedDeposit != null) {
                return ResponseEntity.ok(updatedDeposit); // La mise à jour a réussi, renvoie le Deposit mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Deposit est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update the adress, wine reference, name, supplier and quantity from a Deposit")
    @PutMapping("/Update/{id}/{wine_reference}/{address_reference}/{supplier_reference}")
    public ResponseEntity<DepositEntity> deleteDeposit(@PathVariable("id") int reference, @RequestBody DepositEntity newDeposit, @PathVariable("wine_reference") int wine_reference, @PathVariable("address_reference") int address_reference, @PathVariable("supplier_reference") int supplier_reference) {
        DepositEntity Deposit = DepositService.getDepositById(reference);

        WineEntity wine = WineService.getWineById(wine_reference);
        AddressEntity address = AddressService.getAddressById(address_reference);
        SupplierEntity supplier = SupplierService.getSupplierById(supplier_reference);

        if (Deposit != null) {
        
            Deposit.setAddress(address);
            Deposit.setWineReference(wine);
            Deposit.setNameDeposit(newDeposit.getNameDeposit());
            Deposit.setSupplierReference(supplier);
            Deposit.setQuantity(newDeposit.getQuantity());

            DepositEntity updatedDeposit = DepositService.updateDeposit(Deposit);
            
            if (updatedDeposit != null) {
                return ResponseEntity.ok(updatedDeposit); // La mise à jour a réussi, renvoie le Deposit mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Deposit est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Make a new deposit")
    @PostMapping("/New/{wine_reference}/{address_reference}/{supplier_reference}")
    public DepositEntity newDeposit(@RequestBody DepositEntity newDeposit, @PathVariable("wine_reference") int wine_reference, @PathVariable("address_reference") int address_reference, @PathVariable("supplier_reference") int supplier_reference) {
        DepositEntity Deposit = new DepositEntity();
        WineEntity wine = WineService.getWineById(wine_reference);
        AddressEntity address = AddressService.getAddressById(address_reference);
        SupplierEntity supplier = SupplierService.getSupplierById(supplier_reference);
    
        Deposit.setAddress(address);
        Deposit.setWineReference(wine);
        Deposit.setNameDeposit(newDeposit.getNameDeposit());
        Deposit.setSupplierReference(supplier);
        Deposit.setQuantity(newDeposit.getQuantity());

        return DepositService.AddDeposit(Deposit);
    }


    @Operation(summary = "Delete d'un Deposit")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<DepositEntity> deleteDeposit(@PathVariable("id") int reference) {
        DepositEntity Deposit = DepositService.getDepositById(reference);
        if (Deposit != null) {
        
            long currentTimeMillis = System.currentTimeMillis();
        
            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Deposit.setDeletionDate(date);

            DepositEntity updatedDeposit = DepositService.updateDeposit(Deposit);
            
            if (updatedDeposit != null) {
                return ResponseEntity.ok(updatedDeposit); // La mise à jour a réussi, renvoie le Deposit mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Deposit est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

}