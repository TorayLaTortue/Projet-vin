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
    private WineService WineService;

    @Operation(summary = "List of all wine")
    @GetMapping("/All")
    public List<WineEntity> getAllWine() {
        return WineService.getAllWine();
    }

    @Operation(summary = "Add a new wine (Name, Picture, Quality, Region, Year, Quantity, Format, Price)")
    @PostMapping("/New")
    public WineEntity newWine(@RequestBody WineEntity newWine) {
        WineEntity Wine = new WineEntity();
        Wine.setName(newWine.getName());
        Wine.setPicture(newWine.getPicture());
        Wine.setWineQuality(newWine.getWineQuality());
        Wine.setRegion(newWine.getRegion());
        Wine.setYear(newWine.getYear());
        Wine.setFamily(newWine.getFamily());
        Wine.setFormat(newWine.getFormat());
        Wine.setPrice(newWine.getPrice());
        return WineService.AddWine(Wine); 
    }



    @Operation(summary = "Update of a wine (Name, Picture, Quality, Region, Year, Format, Price)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<WineEntity> UpdateWine(@PathVariable("id") int reference, @RequestBody WineEntity newWine) {
        WineEntity Wine = WineService.getWineById(reference);
        if (Wine != null) {
        
            Wine.setName(newWine.getName());
            Wine.setPicture(newWine.getPicture());
            Wine.setWineQuality(newWine.getWineQuality());
            Wine.setRegion(newWine.getRegion());
            Wine.setYear(newWine.getYear());
            Wine.setFamily(newWine.getFamily());
            Wine.setFormat(newWine.getFormat());
            Wine.setPrice(newWine.getPrice());

            WineEntity updatedWine = WineService.updateWine(Wine);
            
            if (updatedWine != null) {
                return ResponseEntity.ok(updatedWine); // La mise à jour a réussi, renvoie le wine mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Wine est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "Add or edit a discount of a wine")
    @PutMapping("/Discount/{id}")
    public ResponseEntity<WineEntity> DiscountWine(@PathVariable("id") int reference, @RequestBody WineEntity newWine) {
        WineEntity Wine = WineService.getWineById(reference);
        if (Wine != null) {
        
            Wine.setDiscount(newWine.getDiscount());

            WineEntity updatedWine = WineService.updateWine(Wine);
            
            if (updatedWine != null) {
                return ResponseEntity.ok(updatedWine); // La mise à jour a réussi, renvoie le wine mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Wine est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete a wine")
    @PutMapping("/Delete/{id}")
    public ResponseEntity<WineEntity> deleteWine(@PathVariable("id") int reference) {
        WineEntity Wine = WineService.getWineById(reference);
        if (Wine != null) {
        
            long currentTimeMillis = System.currentTimeMillis();
        
            // Création d'une instance de java.sql.Date avec la date actuelle
            Date date = new Date(currentTimeMillis);

            Wine.setDeletionDate(date); 

            WineEntity updatedWine = WineService.updateWine(Wine);
            
            if (updatedWine != null) {
                return ResponseEntity.ok(updatedWine); // La mise à jour a réussi, renvoie le wine mis à jour
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