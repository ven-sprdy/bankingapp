package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
