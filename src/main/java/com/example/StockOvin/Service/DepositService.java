package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.DepositEntity;
import com.example.StockOvin.Repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositService implements IDepositService {

    @Autowired
    private DepositRepository DepositRepository;

    @Override
    public List<DepositEntity> getAllDeposit() {
        return DepositRepository.findAll();
    }

    public DepositEntity AddDeposit(DepositEntity deposit) {
        return DepositRepository.save(deposit);
    }

    public DepositEntity getDepositById(int id) {
        return DepositRepository.findById(id).orElse(null);
    }

    public DepositEntity updateDeposit(DepositEntity deposit) {
        return DepositRepository.save(deposit);
    }

}
