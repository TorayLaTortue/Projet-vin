
package com.example.StockOvin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Repository.WineRepository;

@Service
public class WineService implements IWineService{

   @Autowired
    private WineRepository WineRepository;

    @Override
    public List<WineEntity> getAllWine() {
        return WineRepository.findAll();
    }
    

    public WineEntity AddWine(WineEntity wine) {
        return WineRepository.save(wine);
    }

    public WineEntity getWineById(int id) {
        return WineRepository.findById(id).orElse(null);
    }

    public WineEntity updateWine(WineEntity wine) {
        return WineRepository.save(wine);
    }

}