package com.example.StockOvin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

import com.example.StockOvin.Entities.VinEntity;
import com.example.StockOvin.Service.VinService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/getAllVins")

public class VinController {

     @Autowired
    private VinService VinService;

    @GetMapping
    public List<VinEntity> getAllVin() {
        return VinService.getAllVin();
    }

    @Operation(summary = "Delete d'un vin")
    @PutMapping("/DeleteVin/{id}")
    public ResponseEntity<VinEntity> deleteVin(@PathVariable("id") int reference, @RequestBody VinEntity newVin) {
        VinEntity Vin = VinService.getVinById(reference);
        if (Vin != null) {
        
            long currentTimeMillis = System.currentTimeMillis();
        
            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Vin.setDate_suppression(date); 

            VinEntity updatedVin = VinService.updateVin(Vin);
            
            if (updatedVin != null) {
                return ResponseEntity.ok(updatedVin); // La mise à jour a réussi, renvoie le vin mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Vin est inexistant, renvoie un statut 404
            return ResponseEntity.notFound().build();
        }
    }

}