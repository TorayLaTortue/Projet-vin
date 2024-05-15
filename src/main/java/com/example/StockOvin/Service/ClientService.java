package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClientService implements IClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientEntity> getAllClient() {
        return clientRepository.findAll();
    }

    public ClientEntity AddClient(ClientEntity client) {
        return clientRepository.save(client);
    }
}
