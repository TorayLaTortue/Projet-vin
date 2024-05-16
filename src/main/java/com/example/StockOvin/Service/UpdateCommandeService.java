package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.UpdateCommandeEntity;
import com.example.StockOvin.Repository.UpdateCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCommandeService {

    @Autowired
    private UpdateCommandeRepository updateCommandeRepository;

    public UpdateCommandeEntity updateCommande(Integer referenceCommande, Integer referenceClient, Integer adresseFacturation, Integer adresseLivraison, Integer referenceVin, Integer quantiteProduit) {
        Optional<UpdateCommandeEntity> commandeOptional = updateCommandeRepository.findById(referenceCommande);
        if (commandeOptional.isPresent()) {
            UpdateCommandeEntity commande = commandeOptional.get();
            // Mise à jour des informations de la commande
            if (referenceClient != null) {
                commande.setReference_client(referenceClient);
            }
            if (adresseFacturation != null) {
                commande.setAdresse_facturation(adresseFacturation);
            }
            if (adresseLivraison != null) {
                commande.setAdresse_livraison(adresseLivraison);
            }
            if (referenceVin != null) {
                commande.setReference_vin(referenceVin);
            }
            if (quantiteProduit != null) {
                commande.setQuantite_produit(quantiteProduit);
            }


            return updateCommandeRepository.save(commande);
        } else {
            // dans le cas où la commande n'est pas trouvée
            return null;
        }
    }
}
