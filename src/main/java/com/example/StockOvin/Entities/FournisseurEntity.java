package com.example.StockOvin.Entities;


import java.util.Date;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "fournisseur")
public class FournisseurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_fournisseur;
    private String nom;
    private Date date_creation;
    private String valeurs_vin;
    @ManyToOne
    @JoinColumn(name = "adresse")
    private AdresseEntity adresse;
    private Date date_suppression;

}