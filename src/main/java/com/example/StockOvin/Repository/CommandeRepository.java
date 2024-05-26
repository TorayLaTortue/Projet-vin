package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<OrderEntity, Long> {
}
