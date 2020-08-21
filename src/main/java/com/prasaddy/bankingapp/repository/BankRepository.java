package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, String> {
}
