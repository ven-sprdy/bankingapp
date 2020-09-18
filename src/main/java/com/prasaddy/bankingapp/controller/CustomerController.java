package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.CustomerDTO;
import com.prasaddy.bankingapp.model.Customer;
import com.prasaddy.bankingapp.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping(value = "/save")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer = customerRepository.save(customer);
        return ResponseEntity.ok(modelMapper.map(customer, CustomerDTO.class));
    }

}
