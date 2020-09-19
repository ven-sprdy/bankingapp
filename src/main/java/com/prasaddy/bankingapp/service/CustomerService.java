package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.CustomerDTO;
import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.model.Customer;
import com.prasaddy.bankingapp.repository.BranchRepository;
import com.prasaddy.bankingapp.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    public ResponseEntity<CustomerDTO> createCustomer(UUID branchId, CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Branch branch = branchRepository.findById(branchId).orElseThrow(EntityNotFoundException::new);
        customer.setBranch(branch);
        customer.getLoans().forEach(loan -> {
            loan.setBranch(branch);
            loan.getCustomers().add(customer);
        });
        return ResponseEntity.ok(modelMapper.map(customerRepository.save(customer), CustomerDTO.class));
    }

}
