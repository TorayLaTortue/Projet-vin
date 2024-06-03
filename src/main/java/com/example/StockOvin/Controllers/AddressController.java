package com.example.StockOvin.Controllers;

import com.example.StockOvin.Entities.AddressEntity;
import com.example.StockOvin.Service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class AddressController {

    @Autowired
    private AddressService AddressService;


    @GetMapping("/address")
    public List<AddressEntity> getAllDeposit() {
        return AddressService.getAllAddress();
    }

    @Operation(summary = "Ajout d'une address (city, street, postal_code)")
    @PostMapping("/Post")
    public AddressEntity newAddress(@RequestBody AddressEntity newAddress) {
        AddressEntity Address = new AddressEntity();
        Address.setCity(newAddress.getCity());
        Address.setStreet(newAddress.getStreet());
        Address.setPostal_code(newAddress.getPostal_code());
        return AddressService.AddAddress(Address);
    }

    @Operation(summary = "Edit d'un Address (Name, Picture, Region, Year, Quantity, Format, Price)")
    @PutMapping("/Update/{id}")
    public ResponseEntity<AddressEntity> UpdateAddress(@PathVariable("id") int reference, @RequestBody AddressEntity newAddress) {
        AddressEntity Address = AddressService.getAddressById(reference);
        if (Address != null) {

            Address.setCity(newAddress.getCity());
            Address.setStreet(newAddress.getStreet());
            Address.setPostal_code(newAddress.getPostal_code());

            AddressEntity updatedAddress = AddressService.updateAddress(Address);

            if (updatedAddress != null) {
                // La mise à jour a réussi
                return ResponseEntity.ok(updatedAddress);
            } else {
                // La mise à jour a échoué
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // L' Address est inexistantz
            return ResponseEntity.notFound().build();
        }
    }
}