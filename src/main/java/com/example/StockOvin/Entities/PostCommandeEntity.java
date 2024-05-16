package com.example.StockOvin.Entities;


import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Entity
@Data
@Table(name = "commande")
public class PostCommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reference_commande")
    private int referenceCommande;

    @ManyToOne
    @JoinColumn(name = "reference_client")
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "adresse_facturation")
    private AdresseEntity adresseFacturation;

    @ManyToOne
    @JoinColumn(name = "adresse_livraison")
    private AdresseEntity adresseLivraison;

    private String statut;

    @Column(name = "date_creation_commande")
    private Date dateCreationCommande;

    @ManyToOne
    @JoinColumn(name = "reference_vin")
    private VinEntity vin;

    @Column(name = "quantite_produit")
    private int quantiteProduit;

    @Column(name = "date_suppression")
    private Date dateSuppression;


    public void setReferenceClient(Integer referenceClient) {
    }

    public void setReferenceVin(int referenceVin) {
    }
}
