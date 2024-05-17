//package com.example.StockOvin.Entities;
//
//import jakarta.persistence.*;
//import java.util.Date;
//
//import io.swagger.v3.oas.annotations.media.Schema;
//
//@Entity
//@Table(name = "commande")
//public class CommandeEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int reference_commande;
//    private int reference_client;
//    private int adresse_facturation;
//    private int adresse_livraison;
//    private String statut;
//    private Date date_creation_commande;
//    private int reference_vin;
//    private int quantite_produit;
//    @Schema(name = "date_suppression")
//    private Date date_suppression;
//
//    public CommandeEntity() {
//    }
//
//    public CommandeEntity(int referenceCommande, int reference_client, int adresse_facturation, int adresse_livraison,
//                        String statut, Date date_creation_commande, int reference_vin, int quantite_produit, Date date_suppression) {
//        this.reference_commande = referenceCommande;
//        this.reference_client = reference_client;
//        this.adresse_facturation = adresse_facturation;
//        this.adresse_livraison = adresse_livraison;
//        this.statut = statut;
//        this.date_creation_commande = date_creation_commande;
//        this.reference_vin = reference_vin;
//        this.quantite_produit = quantite_produit;
//        this.date_suppression = date_suppression;
//    }
//
//    public int getReference_commande() {
//        return reference_commande;
//    }
//
//    public void setReference_commande(int referenceCommande) {
//        this.reference_commande = referenceCommande;
//    }
//
//    public int getReference_client() {
//        return reference_client;
//    }
//
//    public void setReference_client(int referenceClient) {
//        this.reference_client = referenceClient;
//    }
//
//    public int getAdresse_facturation() {
//        return adresse_facturation;
//    }
//
//    public void setAdresse_facturation(int adresseFacturation) {
//        this.adresse_facturation = adresseFacturation;
//    }
//
//    public int getAdresse_livraison() {
//        return adresse_livraison;
//    }
//
//    public void setAdresse_livraison(int adresseLivraison) {
//        this.adresse_livraison = adresseLivraison;
//    }
//
//    public String getStatut() {
//        return statut;
//    }
//
//    public void setStatut(String statut) {
//        this.statut = statut;
//    }
//
//    public Date getDate_creation_commande() {
//        return date_creation_commande;
//    }
//
//    public void setDate_creation_commande(Date dateCreationCommande) {
//        this.date_creation_commande = dateCreationCommande;
//    }
//
//    public int getReference_vin() {
//        return reference_vin;
//    }
//
//    public void setReference_vin(int referenceVin) {
//        this.reference_vin = referenceVin;
//    }
//
//    public int getQuantite_produit() {
//        return quantite_produit;
//    }
//
//    public void setQuantite_produit(int quantiteProduit) {
//        this.quantite_produit = quantiteProduit;
//    }
//
//    public Date getDate_suppression() {
//        return date_suppression;
//    }
//
//    public void setDate_suppression(Date dateSuppression) {
//        this.date_suppression = dateSuppression;
//    }
//}
