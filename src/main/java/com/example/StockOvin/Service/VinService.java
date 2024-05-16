
package com.example.StockOvin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockOvin.Entities.VinEntity;
import com.example.StockOvin.Repository.VinRepository;

@Service
public class VinService implements IVinService{

   @Autowired
    private VinRepository VinRepository;

    @Override
    public List<VinEntity> getAllVin() {
        return VinRepository.findAll();
    }
    

    public VinEntity AddVin(VinEntity vin) {
        return VinRepository.save(vin);
    }

    public VinEntity getVinById(int id) {
        return VinRepository.findById(id).orElse(null);
    }

    public VinEntity updateVin(VinEntity vin) {
        return VinRepository.save(vin);
    }

}