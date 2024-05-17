package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.FournisseurEntity;
import com.example.StockOvin.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService implements IFournisseurService {

    @Autowired
    private FournisseurRepository FournisseurRepository;

    @Override
    public List<FournisseurEntity> getAllFournisseur() {
        return FournisseurRepository.findAll();
    }

    public FournisseurEntity AddFournisseur(FournisseurEntity Fournisseur) {
        return FournisseurRepository.save(Fournisseur);
    }

    public FournisseurEntity getFournisseurById(int id) {
        return FournisseurRepository.findById(id).orElse(null);
    }

    public FournisseurEntity updateFournisseur(FournisseurEntity Fournisseur) {
        return FournisseurRepository.save(Fournisseur);
    }

}
