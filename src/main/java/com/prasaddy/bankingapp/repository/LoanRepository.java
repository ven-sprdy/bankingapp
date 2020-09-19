package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
}
