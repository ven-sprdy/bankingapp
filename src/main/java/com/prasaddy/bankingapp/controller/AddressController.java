package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.AddressDTO;
import com.prasaddy.bankingapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/{addressId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public AddressDTO getAddressById(@PathVariable UUID addressId) {
        return addressService.getAddressById(addressId);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public AddressDTO createAddresses(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddresses(addressDTO);
    }

    @PutMapping(value = "/{addressId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public AddressDTO updateBankDetails(@PathVariable UUID bankId, @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddressById(bankId, addressDTO);
    }

    @DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteAllAddresses() {
        addressService.deleteAllAddresses();
    }

    @DeleteMapping(value = "/{addressId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteAddressById(@PathVariable UUID addressId) {
        addressService.deleteAddressById(addressId);
    }

}
