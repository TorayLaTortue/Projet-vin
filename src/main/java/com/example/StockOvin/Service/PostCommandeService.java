package com.example.StockOvin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StockOvin.Entities.PostCommandeEntity;
import com.example.StockOvin.Repository.PostCommandeRepository;

@Service
public class PostCommandeService {

    @Autowired
    private PostCommandeRepository postCommandeRepository;

    public PostCommandeEntity createCommande(PostCommandeEntity commande) {

        return postCommandeRepository.save(commande);
    }

}
