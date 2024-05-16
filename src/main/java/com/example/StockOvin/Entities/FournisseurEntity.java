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
    private int valeurs_vin;
    private Date date_suppression;

}