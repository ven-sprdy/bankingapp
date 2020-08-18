package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity, String> {
}
