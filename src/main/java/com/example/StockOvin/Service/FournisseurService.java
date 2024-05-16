package com.example.StockOvin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockOvin.Entities.FournisseurEntity;
import com.example.StockOvin.Repository.FournisseurRepository;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<FournisseurEntity> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }
}