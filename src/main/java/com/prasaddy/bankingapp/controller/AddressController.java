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

import java.util.Set;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/{addressId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public AddressDTO getAddressById(@PathVariable String addressId) {
        return addressService.getAddressById(addressId);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void createAddresses(@RequestBody Set<AddressDTO> addresses) {
        addressService.createAddresses(addresses);
    }

    @PutMapping(value = "/{addressId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void updateBankDetails(@PathVariable String bankId, @RequestBody AddressDTO address) {
        addressService.updateAddressById(bankId, address);
    }

    @DeleteMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteAllAddresses() {
        addressService.deleteAllAddresses();
    }

    @DeleteMapping(value = "/{addressId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void deleteAddressById(@PathVariable String addressId) {
        addressService.deleteAddressById(addressId);
    }

}
