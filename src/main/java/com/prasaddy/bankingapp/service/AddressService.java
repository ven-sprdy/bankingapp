package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.AddressDTO;
import com.prasaddy.bankingapp.model.Address;
import com.prasaddy.bankingapp.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<AddressDTO> getAddressById(UUID addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(modelMapper.map(address, AddressDTO.class));
    }

    public ResponseEntity<AddressDTO> createAddress(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address = addressRepository.save(address);
        return ResponseEntity.ok(modelMapper.map(address, AddressDTO.class));
    }

    public ResponseEntity<AddressDTO> updateAddressById(UUID addressId, AddressDTO addressDTO) {
        Address oldAddress = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        addressDTO.setAddressId(addressId);
        Address newAddress = modelMapper.map(addressDTO, Address.class);
        BeanUtils.copyProperties(newAddress, oldAddress);
        Address address = addressRepository.save(newAddress);
        return ResponseEntity.ok(modelMapper.map(address, AddressDTO.class));
    }

    public ResponseEntity<String> deleteAllAddresses() {
        addressRepository.deleteAll();
        return ResponseEntity.ok("All addresses deleted.");
    }

    public ResponseEntity<String> deleteAddressById(UUID addressId) {
        addressRepository.deleteById(addressId);
        return ResponseEntity.ok("Address deleted by ID: " +addressId);
    }

}
