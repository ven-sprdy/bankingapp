package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.CustomerDTO;
import com.prasaddy.bankingapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/branches")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "/{branchId}/customers/save")
    public ResponseEntity<CustomerDTO> createCustomer(@PathVariable UUID branchId, @RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(branchId, customerDTO);
    }

}
