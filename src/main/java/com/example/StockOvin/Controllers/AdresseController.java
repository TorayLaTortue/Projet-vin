package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AdresseEntity;
import com.example.StockOvin.Service.AdresseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class AdresseController {

    @Autowired
    private AdresseService AdresseService;


    @GetMapping("/adresse")
    public List<AdresseEntity> getAllDepot() {
        return AdresseService.getAllAdresse();
    }

    @Operation(summary = "Ajout d'une adresse (ville, rue, code_postal)")
    @PostMapping("/Post")
    public AdresseEntity newAdresse(@RequestBody AdresseEntity newAdresse) {
        AdresseEntity Adresse = new AdresseEntity();
        Adresse.setVille(newAdresse.getVille());
        Adresse.setRue(newAdresse.getRue());
        Adresse.setCode_postal(newAdresse.getCode_postal());
        return AdresseService.AddAdresse(Adresse);
    }

    @Operation(summary = "Edit d'un Adresse (Nom, Image, Region, Annee, Quantite, Format, Prix)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<AdresseEntity> UpdateAdresse(@PathVariable("id") int reference, @RequestBody AdresseEntity newAdresse) {
        AdresseEntity Adresse = AdresseService.getAdresseById(reference);
        if (Adresse != null) {

            Adresse.setVille(newAdresse.getVille());
            Adresse.setRue(newAdresse.getRue());
            Adresse.setCode_postal(newAdresse.getCode_postal());

            AdresseEntity updatedAdresse = AdresseService.updateAdresse(Adresse);

            if (updatedAdresse != null) {
                // La mise à jour a réussi
                return ResponseEntity.ok(updatedAdresse);
            } else {
                // La mise à jour a échoué
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // L' Adresse est inexistantz
            return ResponseEntity.notFound().build();
        }
    }
}