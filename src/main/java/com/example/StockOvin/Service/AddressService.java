package com.example.StockOvin.Service;

import com.example.StockOvin.Entities.AddressEntity;
import com.example.StockOvin.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository AddressRepository;

    @Override
    public List<AddressEntity> getAllAddress() {
        return AddressRepository.findAll();
    }

    public AddressEntity AddAddress(AddressEntity address) {
        return AddressRepository.save(address);
    }
    public AddressEntity updateAddress(AddressEntity address) {
        return AddressRepository.save(address);
    }
    public AddressEntity getAddressById(int id) {
        return AddressRepository.findById(id).orElse(null);
    }


}
