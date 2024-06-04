package com.example.StockOvin.Entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "wine")
public class WineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wine_reference;
    private String name;
    private String picture;
    private String wine_quality;
    private String region;
    private String family;
    private Date year;
    private String format;
    private float discount;
    private int price;
    private Date deletion_date;

    // Constructeur
    public WineEntity(int wine_reference, String name, String picture, String wine_quality, String region, String family, Date year, String format, float discount, int price, Date deletion_date) {
        this.wine_reference = wine_reference;
        this.name = name;
        this.picture = picture;
        this.wine_quality = wine_quality;
        this.region = region;
        this.family = family;
        this.year = year;
        this.format = format;
        this.discount = discount;
        this.price = price;
        this.deletion_date = deletion_date;
    }

    // Constructeur vide
    public WineEntity() {
    }

    // Getters et Setters
    public int getWineReference() {
        return wine_reference;
    }

    public void setWineReference(int wine_reference) {
        this.wine_reference = wine_reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getWineQuality() {
        return wine_quality;
    }
    public void setWineQuality(String wine_quality) {
        this.wine_quality = wine_quality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDeletionDate() {
        return deletion_date;
    }

    public void setDeletionDate(Date deletion_date) {
        this.deletion_date = deletion_date;
    }

}
