
package com.example.StockOvin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockOvin.Entities.VinEntity;
import com.example.StockOvin.Repository.VinRepository;

@Service
public class VinService {

   @Autowired
    private VinRepository vinRepository;

    public List<VinEntity> getAllVins() {
        return vinRepository.findAll();
    }
    

    }