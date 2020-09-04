package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.AddressDTO;
import com.prasaddy.bankingapp.model.Address;
import com.prasaddy.bankingapp.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public AddressDTO getAddressById(UUID addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(address, AddressDTO.class);
    }

    public AddressDTO createAddresses(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address = addressRepository.save(address);
        return modelMapper.map(address, AddressDTO.class);
    }

    public AddressDTO updateAddressById(UUID addressId, AddressDTO addressDTO) {
        Address oldAddress = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        Address newAddress = modelMapper.map(addressDTO, Address.class);
        BeanUtils.copyProperties(newAddress, oldAddress);
        newAddress = addressRepository.save(newAddress);
        return modelMapper.map(newAddress, AddressDTO.class);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }

    public void deleteAddressById(UUID bankId) {
        addressRepository.deleteById(bankId);
    }

}
