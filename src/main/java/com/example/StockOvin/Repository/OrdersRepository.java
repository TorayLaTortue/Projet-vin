package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
}
