package com.example.StockOvin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/Vin")

public class VinController {

     @Autowired
    private VinService VinService;

    @Operation(summary = "Liste de toutes les infos de tout les vin")
    @GetMapping("/Vin")
    public List<VinEntity> getAllVin() {
        return VinService.getAllVin();
    }

    @Operation(summary = "Ajout d'un vin (Nom, Image, Region, Annee, Quantite, Format, Prix)")
    @PostMapping("/Post")
    public VinEntity AddVin(@RequestBody VinEntity newVin) {
        VinEntity Vin = new VinEntity();
        Vin.setNom(newVin.getNom());
        Vin.setImage(newVin.getImage());
        Vin.setRegion(newVin.getRegion());
        Vin.setAnnee(newVin.getAnnee());
        Vin.setQuantite(newVin.getQuantite());
        Vin.setFormat(newVin.getFormat());
        Vin.setPrix(newVin.getPrix());
        return VinService.AddVin(Vin); 
    }

    @Operation(summary = "Edit d'un vin (Nom, Image, Region, Annee, Quantite, Format, Prix)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<VinEntity> UpdateVin(@PathVariable("id") int reference, @RequestBody VinEntity newVin) {
        VinEntity Vin = VinService.getVinById(reference);
        if (Vin != null) {
        
            Vin.setNom(Vin.getNom());
            Vin.setImage(Vin.getImage());
            Vin.setRegion(Vin.getRegion());
            Vin.setAnnee(Vin.getAnnee());
            Vin.setQuantite(Vin.getQuantite());
            Vin.setFormat(Vin.getFormat());
            Vin.setPrix(Vin.getPrix());

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

    @Operation(summary = "Ajout ou modification d'une promotion de vin")
    @PutMapping("/Promotion/{id}")
    public ResponseEntity<VinEntity> PromotionVin(@PathVariable("id") int reference, @RequestBody VinEntity newVin) {
        VinEntity Vin = VinService.getVinById(reference);
        if (Vin != null) {
        
            Vin.setPromotion(Vin.getPromotion());

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

    @Operation(summary = "Delete d'un vin")
    @PutMapping("/Delete/{id}")
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