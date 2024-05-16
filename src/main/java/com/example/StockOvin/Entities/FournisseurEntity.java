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
    private int referencefournisseur;
    private String nom;
    private Date datecreation;
    private int valeursvin;
    private Date datesuppression;

}