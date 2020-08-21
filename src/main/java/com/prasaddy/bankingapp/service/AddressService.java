package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.AddressDTO;
import com.prasaddy.bankingapp.model.Address;
import com.prasaddy.bankingapp.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public AddressDTO getAddressById(String addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(address, AddressDTO.class);
    }

    public void createAddresses(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        addressRepository.save(address);
    }

    public void updateAddressById(String addressId, AddressDTO addressDTO) {
        Address oldAddress = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        Address newAddress = modelMapper.map(addressDTO, Address.class);
        BeanUtils.copyProperties(newAddress, oldAddress);
        addressRepository.save(newAddress);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }

    public void deleteAddressById(String bankId) {
        addressRepository.deleteById(bankId);
    }

}
