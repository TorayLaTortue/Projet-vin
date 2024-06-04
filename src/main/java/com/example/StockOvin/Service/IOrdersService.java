package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.OrdersEntity;

import java.util.List;

public interface IOrdersService {

    List<OrdersEntity> getAllOrders();
}
