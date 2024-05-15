package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.DepotEntity;
import com.example.StockOvin.Repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepotService implements IDepotService {

    @Autowired
    private DepotRepository DepotRepository;

    @Override
    public List<DepotEntity> getAllDepot() {
        return DepotRepository.findAll();
    }

}