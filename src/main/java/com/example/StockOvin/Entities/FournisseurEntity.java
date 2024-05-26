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
    private int supplier_reference;
    private String name;
    private Date date_creation;
    private String valeurs_vin;
    @JoinColumn(name = "address")
    private int address;
    private Date deletion_date;

}