package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.OrderEntity;
import com.example.StockOvin.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository CommandeRepository;

    public OrderEntity createCommande(OrderEntity commande) {
        return CommandeRepository.save(commande);
    }

    public OrderEntity updateCommande(OrderEntity commande) {
        return CommandeRepository.save(commande);
    }

    public List<OrderEntity> getAllCommande() {
        return CommandeRepository.findAll();
    }
}
