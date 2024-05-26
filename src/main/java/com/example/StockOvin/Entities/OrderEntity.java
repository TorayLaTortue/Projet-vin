package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_reference")
    private Long orderReference;

    @Column(name = "client_reference")
    private Long referenceClient;

    @Column(name = "billing_address")
    private Long addressFacturation;

    @Column(name = "delivery_address")
    private Long deliveryAddress;

    @Column(name = "wine_reference")
    private Long wineReference;

    @Column(name = "quantity_product")
    private Integer quantityProduct;

    @Column(name = "status")
    private String status;

    @Column(name = "order_creation_date")
    private LocalDate orderCreationDate;
}
