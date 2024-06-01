
package com.example.StockOvin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockOvin.Entities.WineEntity;
import com.example.StockOvin.Repository.WineRepository;

@Service
public class WineService implements IWineService{

   @Autowired
    private WineRepository VinRepository;

    @Override
    public List<WineEntity> getAllVin() {
        return VinRepository.findAll();
    }
    

    public WineEntity AddVin(WineEntity wine) {
        return VinRepository.save(wine);
    }

    public WineEntity getVinById(int id) {
        return VinRepository.findById(id).orElse(null);
    }

    public WineEntity updateVin(WineEntity wine) {
        return VinRepository.save(wine);
    }

}