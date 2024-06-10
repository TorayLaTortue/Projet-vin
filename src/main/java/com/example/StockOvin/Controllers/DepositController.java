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
import io.swagger.v3.oas.annotations.Parameter;

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
    @PutMapping("/SubQuantity/{id}")
    public ResponseEntity<DepositEntity> reductionDeposit(
            @PathVariable("id") int reference,
            @Parameter(description = "substract") @RequestParam int modification) {
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
    @PutMapping("/AddQuantity/{id}")
    public ResponseEntity<DepositEntity> ajouterpDeposit(
            @PathVariable("id") int reference,
            @Parameter(description = "add") @RequestParam int modification) {
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
    @PutMapping("/Update/{id}")
    public ResponseEntity<DepositEntity> deleteDeposit(
            @PathVariable("id") int reference,
            @Parameter(description = "wine_reference") @RequestParam int wine_reference,
            @Parameter(description = "address_reference") @RequestParam int address_reference,
            @Parameter(description = "supplier_reference") @RequestParam int supplier_reference,
            @Parameter(description = "name") @RequestParam String name,
            @Parameter(description = "quantity") @RequestParam int quantity) {
        DepositEntity Deposit = DepositService.getDepositById(reference);

        WineEntity wine = WineService.getWineById(wine_reference);
        AddressEntity address = AddressService.getAddressById(address_reference);
        SupplierEntity supplier = SupplierService.getSupplierById(supplier_reference);

        if (Deposit != null) {

            Deposit.setAddress(address);
            Deposit.setWineReference(wine);
            Deposit.setNameDeposit(name);
            Deposit.setSupplierReference(supplier);
            Deposit.setQuantity(quantity);

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

    @PostMapping("/New")
    public DepositEntity newDeposit(
            @Parameter(description = "name") @RequestParam(required = false) String name,
            @Parameter(description = "wine_reference") @RequestParam(required = false) String wine_reference,
            @Parameter(description = "address_reference") @RequestParam(required = false) String address_reference,
            @Parameter(description = "supplier_reference") @RequestParam(required = false) String supplier_reference,
            @Parameter(description = "quantity") @RequestParam(required = false) String quantity) {

        DepositEntity deposit = new DepositEntity();

        if (wine_reference != null && !wine_reference.equals("null")) {
            WineEntity wine = WineService.getWineById(Integer.parseInt(wine_reference));
            deposit.setWineReference(wine);
        }

        if (address_reference != null && !address_reference.equals("null")) {
            AddressEntity address = AddressService.getAddressById(Integer.parseInt(address_reference));
            deposit.setAddress(address);
        }

        if (supplier_reference != null && !supplier_reference.equals("null")) {
            SupplierEntity supplier = SupplierService.getSupplierById(Integer.parseInt(supplier_reference));
            deposit.setSupplierReference(supplier);
        }

        if (name != null) {
            deposit.setNameDeposit(name);
        }

        if (quantity != null && !quantity.equals("null")) {
            deposit.setQuantity(Integer.parseInt(quantity));
        }

        return DepositService.AddDeposit(deposit);
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