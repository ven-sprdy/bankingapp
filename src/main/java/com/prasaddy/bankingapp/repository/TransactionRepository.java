package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
