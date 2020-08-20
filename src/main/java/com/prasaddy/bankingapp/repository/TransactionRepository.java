package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
