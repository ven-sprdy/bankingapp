package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.AddressDTO;
import com.prasaddy.bankingapp.model.AddressEntity;
import com.prasaddy.bankingapp.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public AddressDTO getAddressById(String addressId) {
        AddressEntity addressEntity = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(addressEntity, AddressDTO.class);
    }

    public void createAddresses(Set<AddressDTO> addressesDetails) {
        addressesDetails.forEach(address -> {
            AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
            addressRepository.save(addressEntity);
        });
    }

    public void updateAddressById(String addressId, AddressDTO address) {
        AddressEntity oldAddressEntity = addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
        AddressEntity newAddressEntity = modelMapper.map(address, AddressEntity.class);
        BeanUtils.copyProperties(newAddressEntity, oldAddressEntity);
        addressRepository.save(newAddressEntity);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }

    public void deleteAddressById(String bankId) {
        addressRepository.deleteById(bankId);
    }

}
