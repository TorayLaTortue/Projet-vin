package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.DepotEntity;
import com.example.StockOvin.Service.DepotService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Depot")
public class DepotController {

    @Autowired
    private DepotService DepotService;


    @GetMapping("/All")
    public List<DepotEntity> getAllDepot() {
        return DepotService.getAllDepot();
    }

    @Operation(summary = "Soustraire du vin dans le stock d'un Depot")
    @PutMapping("/ReductionStock/{id}/{moin}")
    public ResponseEntity<DepotEntity> reductionDepot(@PathVariable("id") int reference, @PathVariable("moin") int modification) {
        DepotEntity Depot = DepotService.getDepotById(reference);
        if (Depot != null) {
            
            Depot.setQuantite(Depot.getQuantite() - modification);

            DepotEntity updatedDepot = DepotService.updateDepot(Depot);
            
            if (updatedDepot != null) {
                return ResponseEntity.ok(updatedDepot); // La mise à jour a réussi, renvoie le Depot mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Depot est inexistant, renvoie un statut 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Ajouter du vin dans le stock d'un Depot")
    @PutMapping("/AjouterStock/{id}/{plus}")
    public ResponseEntity<DepotEntity> ajouterpDepot(@PathVariable("id") int reference, @PathVariable("plus") int modification) {
        DepotEntity Depot = DepotService.getDepotById(reference);
        if (Depot != null) {
            
            Depot.setQuantite(Depot.getQuantite() + modification);

            DepotEntity updatedDepot = DepotService.updateDepot(Depot);
            
            if (updatedDepot != null) {
                return ResponseEntity.ok(updatedDepot); // La mise à jour a réussi, renvoie le Depot mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Depot est inexistant, renvoie un statut 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update d'un Depot")
    @PutMapping("/Update/{id}")
    public ResponseEntity<DepotEntity> deleteDepot(@PathVariable("id") int reference, @RequestBody DepotEntity newDepot) {
        DepotEntity Depot = DepotService.getDepotById(reference);
        if (Depot != null) {
        
            Depot.setAdresse(newDepot.getAdresse());
            Depot.setReference_vin(newDepot.getReference_vin());
            Depot.setNom_depot(newDepot.getNom_depot());
            Depot.setReference_fournisseur(newDepot.getReference_fournisseur());
            Depot.setQuantite(newDepot.getQuantite());

            DepotEntity updatedDepot = DepotService.updateDepot(Depot);
            
            if (updatedDepot != null) {
                return ResponseEntity.ok(updatedDepot); // La mise à jour a réussi, renvoie le Depot mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Depot est inexistant, renvoie un statut 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Ajout d'un Depot")
    @PostMapping("/New")
    public DepotEntity newDepot(@RequestBody DepotEntity newDepot) {
        DepotEntity Depot = new DepotEntity();
    
        Depot.setAdresse(newDepot.getAdresse());
        Depot.setReference_vin(newDepot.getReference_vin());
        Depot.setNom_depot(newDepot.getNom_depot());
        Depot.setReference_fournisseur(newDepot.getReference_fournisseur());
        Depot.setQuantite(newDepot.getQuantite());

        return DepotService.AddDepot(Depot);
    
    }


    @Operation(summary = "Delete d'un Depot")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<DepotEntity> deleteDepot(@PathVariable("id") int reference) {
        DepotEntity Depot = DepotService.getDepotById(reference);
        if (Depot != null) {
        
            long currentTimeMillis = System.currentTimeMillis();
        
            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Depot.setDate_suppression(date);

            DepotEntity updatedDepot = DepotService.updateDepot(Depot);
            
            if (updatedDepot != null) {
                return ResponseEntity.ok(updatedDepot); // La mise à jour a réussi, renvoie le Depot mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Depot est inexistant, renvoie un statut 404
            return ResponseEntity.notFound().build();
        }
    }

}