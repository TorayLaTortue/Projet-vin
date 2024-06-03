package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.OrdersEntity;
import com.example.StockOvin.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository CommandeRepository;

    public OrdersEntity createCommande(OrdersEntity commande) {
        return CommandeRepository.save(commande);
    }

    public OrdersEntity updateCommande(OrdersEntity commande) {
        return CommandeRepository.save(commande);
    }

    public List<OrdersEntity> getAllCommande() {
        return CommandeRepository.findAll();
    }
}
