package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}
