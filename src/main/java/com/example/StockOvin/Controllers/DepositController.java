package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.DepositEntity;
import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.DepositService;
import com.example.StockOvin.Service.WineService;

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


    @GetMapping("/dépôt")
    public List<DepositEntity> getAllDeposit() {
        return DepositService.getAllDeposit();
    }

    @Operation(summary = "Soustraire du wine dans le stock d'un Deposit")
    @PutMapping("/ReductionStock/{id}/{moin}")
    public ResponseEntity<DepositEntity> reductionDeposit(@PathVariable("id") int reference, @PathVariable("moin") int modification) {
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

    @Operation(summary = "Ajouter du wine dans le stock d'un Deposit")
    @PutMapping("/AjouterStock/{id}/{plus}")
    public ResponseEntity<DepositEntity> ajouterpDeposit(@PathVariable("id") int reference, @PathVariable("plus") int modification) {
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

    @Operation(summary = "Update d'un Deposit")
    @PutMapping("/Update/{id}")
    public ResponseEntity<DepositEntity> deleteDeposit(@PathVariable("id") int reference, @RequestBody DepositEntity newDeposit) {
        DepositEntity Deposit = DepositService.getDepositById(reference);
        if (Deposit != null) {
        
            Deposit.setAddress(newDeposit.getAddress());
            Deposit.setWineReference(newDeposit.getWineReference());
            Deposit.setNameDeposit(newDeposit.getNameDeposit());
            Deposit.setSupplierReference(newDeposit.getSupplierReference());
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

    @Operation(summary = "Ajout d'un Deposit")
    @PostMapping("/New/{wine_reference}")
    public DepositEntity newDeposit(@RequestBody DepositEntity newDeposit, @PathVariable("wine_reference") int wine_reference) {
        DepositEntity Deposit = new DepositEntity();
        WineEntity wine = WineService.getVinById(wine_reference); 
    
        Deposit.setAddress(newDeposit.getAddress());
        Deposit.setWineReference(wine);
        Deposit.setNameDeposit(newDeposit.getNameDeposit());
        Deposit.setSupplierReference(newDeposit.getSupplierReference());
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