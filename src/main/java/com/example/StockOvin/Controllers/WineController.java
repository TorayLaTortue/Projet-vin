package com.example.StockOvin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Service.WineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


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
    public ResponseEntity<Integer> newWine(
        @Parameter(description = "Name of the wine") @RequestParam String name,
        @Parameter(description = "Picture of the wine") @RequestParam String picture,
        @Parameter(description = "Quality of the wine") @RequestParam String wineQuality,
        @Parameter(description = "Region of the wine") @RequestParam String region,
        @Parameter(description = "Year of the wine") @RequestParam Date year,
        @Parameter(description = "Family of the wine") @RequestParam String family,
        @Parameter(description = "Format of the wine") @RequestParam String format,
        @Parameter(description = "Price of the wine") @RequestParam int price) {
    
        WineEntity Wine = new WineEntity();
        Wine.setName(name);
        Wine.setPicture(picture);
        Wine.setWineQuality(wineQuality);
        Wine.setRegion(region);
        Wine.setYear(year);
        Wine.setFamily(family);
        Wine.setFormat(format);
        Wine.setPrice(price);

        WineEntity savedWine = WineService.AddWine(Wine); 
        return ResponseEntity.ok(savedWine.getWineReference());

    }



    @Operation(summary = "Update of a wine (Name, Picture, Quality, Region, Year, Format, Price)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<WineEntity> UpdateWine(
        @PathVariable("id") int reference,
        @Parameter(description = "Name of the wine") @RequestParam String name,
        @Parameter(description = "Picture of the wine") @RequestParam String picture,
        @Parameter(description = "Quality of the wine") @RequestParam String wineQuality,
        @Parameter(description = "Region of the wine") @RequestParam String region,
        @Parameter(description = "Year of the wine") @RequestParam Date year,
        @Parameter(description = "Family of the wine") @RequestParam String family,
        @Parameter(description = "Format of the wine") @RequestParam String format,
        @Parameter(description = "Price of the wine") @RequestParam int price) {
        WineEntity Wine = WineService.getWineById(reference);
        if (Wine != null) {
        
            Wine.setName(name);
            Wine.setPicture(picture);
            Wine.setWineQuality(wineQuality);
            Wine.setRegion(region);
            Wine.setYear(year);
            Wine.setFamily(family);
            Wine.setFormat(format);
            Wine.setPrice(price);
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
    public ResponseEntity<WineEntity> DiscountWine(
        @PathVariable("id") int reference,
        @Parameter(description = "New discount") @RequestParam int discount) {
        WineEntity Wine = WineService.getWineById(reference);
        if (Wine != null) {
        
            Wine.setDiscount(discount);

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