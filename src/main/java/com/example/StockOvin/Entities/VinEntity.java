package com.example.StockOvin.Entities;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data   // generer les methodes gettes, setters et constructeurs ... 
@Table(name = "vin")
public class VinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_vin;

    
    private String nom;
    private String image;
    private String region;
    private String famille;
    private Date annee;
    private int quantite;
    private String format;
    private float promotion;
    private int prix;
    private Date date_suppression;

}






