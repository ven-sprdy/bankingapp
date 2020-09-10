package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
