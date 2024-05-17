package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.AdresseEntity;
import com.example.StockOvin.Repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService implements IAdresseService {

    @Autowired
    private AdresseRepository AdresseRepository;

    @Override
    public List<AdresseEntity> getAllAdresse() {
        return AdresseRepository.findAll();
    }

    public AdresseEntity AddAdresse(AdresseEntity adresse) {
        return AdresseRepository.save(adresse);
    }
    public AdresseEntity updateAdresse(AdresseEntity adresse) {
        return AdresseRepository.save(adresse);
    }
    public AdresseEntity getAdresseById(int id) {
        return AdresseRepository.findById(id).orElse(null);
    }


}
