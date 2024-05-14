package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.ClientEntity;
import com.example.StockOvin.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository ClientRepository;

    @Override
    public List<ClientEntity> getAllClient() {
        return ClientRepository.findAll();
    }

}
