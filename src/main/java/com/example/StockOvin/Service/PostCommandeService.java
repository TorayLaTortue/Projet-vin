package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.PostCommandeEntity;
import com.example.StockOvin.Repository.PostCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommandeService {

    @Autowired
    private PostCommandeRepository postCommandeRepository;

    public PostCommandeEntity createCommande(PostCommandeEntity commande) {
        return postCommandeRepository.save(commande);
    }

    public PostCommandeEntity updateCommande(PostCommandeEntity commande) {
        return postCommandeRepository.save(commande);
    }
}
