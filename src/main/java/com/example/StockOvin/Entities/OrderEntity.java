package com.example.StockOvin.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_reference")
    private Long orderReference;

    @Column(name = "client_reference")
    private Long clientReference;

    @Column(name = "billing_address")
    private Long billingAddress;

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

    // Constructor
    public OrderEntity() {}

    public OrderEntity(Long orderReference, Long clientReference, Long billingAddress, Long deliveryAddress, Long wineReference, Integer quantityProduct, String status, LocalDate orderCreationDate) {
        this.orderReference = orderReference;
        this.clientReference = clientReference;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.wineReference = wineReference;
        this.quantityProduct = quantityProduct;
        this.status = status;
        this.orderCreationDate = orderCreationDate;
    }

    // Getters and Setters in camel case
    public Long getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(Long orderReference) {
        this.orderReference = orderReference;
    }

    public Long getClientReference() {
        return clientReference;
    }

    public void setClientReference(Long clientReference) {
        this.clientReference = clientReference;
    }

    public Long getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Long billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Long getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Long deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Long getWineReference() {
        return wineReference;
    }

    public void setWineReference(Long wineReference) {
        this.wineReference = wineReference;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(LocalDate orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }
}
