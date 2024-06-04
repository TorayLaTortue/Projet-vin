package com.example.StockOvin.Service;

import java.util.List;

import com.example.StockOvin.Entities.OrdersEntity;

public interface IOrdersService {

    List<OrdersEntity> getAllOrders();
}