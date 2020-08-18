package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}
