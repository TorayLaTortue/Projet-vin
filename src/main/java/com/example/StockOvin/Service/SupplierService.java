package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.SupplierEntity;
import com.example.StockOvin.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    private SupplierRepository SupplierRepository;

    @Override
    public List<SupplierEntity> getAllSupplier() {
        return SupplierRepository.findAll();
    }

    public SupplierEntity addSupplier(SupplierEntity Supplier) {
        return SupplierRepository.save(Supplier);
    }

    public SupplierEntity getSupplierById(int id) {
        return SupplierRepository.findById(id).orElse(null);
    }

    public SupplierEntity updateSupplier(SupplierEntity Supplier) {
        return SupplierRepository.save(Supplier);
    }

}
