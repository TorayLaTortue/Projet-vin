package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "commande")
public class UpdateCommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reference_commande;

    @Column(name = "reference_client")
    private Integer reference_client;

    @Column(name = "adresse_facturation")
    private Integer adresse_facturation;

    @Column(name = "adresse_livraison")
    private Integer adresse_livraison;

    @Column(name = "statut")
    private String statut;

    @Column(name = "date_creation_commande")
    private Date date_creation_commande;

    @Column(name = "reference_vin")
    private Integer reference_vin;

    @Column(name = "quantite_produit")
    private Integer quantite_produit;

    @Column(name = "date_suppression")
    private Date date_suppression;
}
