package com.example.StockOvin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;
import java.util.List;

import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.WineService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Wine")

public class WineController {

     @Autowired
    private WineService VinService;

    @Operation(summary = "Liste de toutes les infos de tout les wine")
    @GetMapping("/Wine")
    public List<WineEntity> getAllVin() {
        return VinService.getAllVin();
    }

    @Operation(summary = "Ajout d'un wine (Name, Picture, Region, Year, Quantity, Format, Price)")
    @PostMapping("/Post")
    public WineEntity newVin(@RequestBody WineEntity newVin) {
        WineEntity Wine = new WineEntity();
        Wine.setName(newVin.getName());
        Wine.setPicture(newVin.getPicture());
        Wine.setRegion(newVin.getRegion());
        Wine.setYear(newVin.getYear());
        Wine.setFamily(newVin.getFamily());
        Wine.setFormat(newVin.getFormat());
        Wine.setPrice(newVin.getPrice());
        return VinService.AddVin(Wine); 
    }



    @Operation(summary = "Edit d'un wine (Name, Picture, Region, Year, Format, Price)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<WineEntity> UpdateVin(@PathVariable("id") int reference, @RequestBody WineEntity newVin) {
        WineEntity Wine = VinService.getVinById(reference);
        if (Wine != null) {
        
            Wine.setName(newVin.getName());
            Wine.setPicture(newVin.getPicture());
            Wine.setRegion(newVin.getRegion());
            Wine.setYear(newVin.getYear());
            Wine.setFamily(newVin.getFamily());
            Wine.setFormat(newVin.getFormat());
            Wine.setPrice(newVin.getPrice());

            WineEntity updatedVin = VinService.updateVin(Wine);
            
            if (updatedVin != null) {
                return ResponseEntity.ok(updatedVin); // La mise à jour a réussi, renvoie le wine mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Wine est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Ajout ou modification d'une discount de wine")
    @PutMapping("/Discount/{id}")
    public ResponseEntity<WineEntity> DiscountVin(@PathVariable("id") int reference, @RequestBody WineEntity newVin) {
        WineEntity Wine = VinService.getVinById(reference);
        if (Wine != null) {
        
            Wine.setDiscount(newVin.getDiscount());

            WineEntity updatedVin = VinService.updateVin(Wine);
            
            if (updatedVin != null) {
                return ResponseEntity.ok(updatedVin); // La mise à jour a réussi, renvoie le wine mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Wine est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete d'un wine")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<WineEntity> deleteVin(@PathVariable("id") int reference) {
        WineEntity Wine = VinService.getVinById(reference);
        if (Wine != null) {
        
            long currentTimeMillis = System.currentTimeMillis();
        
            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Wine.setDeletionDate(date); 

            WineEntity updatedVin = VinService.updateVin(Wine);
            
            if (updatedVin != null) {
                return ResponseEntity.ok(updatedVin); // La mise à jour a réussi, renvoie le wine mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Wine est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

}