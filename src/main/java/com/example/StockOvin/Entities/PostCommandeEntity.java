package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "statut")
    private String statut;

    @Column(name = "date_creation_commande")
    private LocalDate dateCreationCommande;
}
