package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "commande")
public class PostCommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_commande")
    private Long referenceCommande;

    @Column(name = "reference_client")
    private Long referenceClient;

    @Column(name = "adresse_facturation")
    private Long adresseFacturation;

    @Column(name = "adresse_livraison")
    private Long adresseLivraison;

    @Column(name = "reference_vin")
    private Long referenceVin;

    @Column(name = "quantite_produit")
    private Integer quantiteProduit;

    // Méthode pour définir le statut de la commande
    @Setter
    @Column(name = "statut")
    private String statut;

    // Méthode pour définir la date de création de la commande
    @Setter
    @Column(name = "date_creation_commande")
    private LocalDate dateCreationCommande;

}
