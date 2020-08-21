package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, String> {

    Page<Branch> findByBankBankId(String bankId, Pageable pageable);
    Optional<Branch> findByBranchIdAndBankBankId(String bankId, String branchId);

}
