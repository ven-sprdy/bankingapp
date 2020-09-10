package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {
}
