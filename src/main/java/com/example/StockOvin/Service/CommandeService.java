package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.CommandeEntity;
import com.example.StockOvin.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository CommandeRepository;

    public CommandeEntity createCommande(CommandeEntity commande) {
        return CommandeRepository.save(commande);
    }

    public CommandeEntity updateCommande(CommandeEntity commande) {
        return CommandeRepository.save(commande);
    }

    public List<CommandeEntity> getAllCommande() {
        return CommandeRepository.findAll();
    }
}
