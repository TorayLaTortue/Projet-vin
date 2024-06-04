package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.OrdersEntity;
import com.example.StockOvin.Repository.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService{

    @Autowired
    private OrdersRepository OrdersRepository;

    public OrdersEntity createOrders(OrdersEntity orders) {
        return OrdersRepository.save(orders);
    }

    public OrdersEntity updateOrders(OrdersEntity orders) {
        return OrdersRepository.save(orders);
    }

    @Override
    public List<OrdersEntity> getAllOrders() {
        return OrdersRepository.findAll();
    }

    public OrdersEntity getOrdersById(int id) {
        return OrdersRepository.findById(id).orElse(null);
    }
}
