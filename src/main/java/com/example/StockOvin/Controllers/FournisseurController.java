package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.FournisseurEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.StockOvin.Service.FournisseurService;

@RestController
@RequestMapping("/getAllFournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<FournisseurEntity> getAllFournisseur() {
        return fournisseurService.getAllFournisseur();
    }


    @Operation(summary = "Nouveau Fournisseur")
    @PostMapping("/newFournisseur")
    public FournisseurEntity newFournisseur(@RequestBody FournisseurEntity newFournisseur) {
        FournisseurEntity Fournisseur = new FournisseurEntity();
        Fournisseur.setName(newFournisseur.getName());
        Fournisseur.setDate_creation(newFournisseur.getDate_creation());
        Fournisseur.setValeurs_vin(newFournisseur.getValeurs_vin());
        Fournisseur.setAddress(newFournisseur.getAddress());
        return fournisseurService.AddFournisseur(Fournisseur);
    }

    @Operation(summary = "Update d'un Fournisseur (Name ,first_name ,eMail ,phone)")
    @PutMapping("/updateFournisseur{id}")
    public ResponseEntity<FournisseurEntity> updateFournisseur(int reference, @RequestBody FournisseurEntity newFournisseur) {
        FournisseurEntity Fournisseur = fournisseurService.getFournisseurById(reference);
        if (Fournisseur != null) {
            Fournisseur.setName(newFournisseur.getName());
            Fournisseur.setDate_creation(newFournisseur.getDate_creation());
            Fournisseur.setValeurs_vin(newFournisseur.getValeurs_vin());
            Fournisseur.setAddress(newFournisseur.getAddress());

            FournisseurEntity updatedFournisseur = fournisseurService.updateFournisseur(Fournisseur);

            if (updatedFournisseur != null) {
                return ResponseEntity.ok(updatedFournisseur); // La mise à jour a réussi, renvoie le Fournisseur mis à jour
            } else {
                // La mise à jour a échoué pour une raison quelconque
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Le Fournisseur est inexistant, renvoie un status 404
            return ResponseEntity.notFound().build();
        }
    }
}