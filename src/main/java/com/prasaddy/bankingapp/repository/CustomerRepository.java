package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
