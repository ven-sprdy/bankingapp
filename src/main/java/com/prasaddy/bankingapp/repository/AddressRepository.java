package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
