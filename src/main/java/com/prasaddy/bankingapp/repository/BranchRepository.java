package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BranchRepository extends JpaRepository<Branch, UUID> {

    Page<Branch> findByBankBankId(UUID bankId, Pageable pageable);
    Optional<Branch> findByBranchIdAndBankBankId(UUID bankId, UUID branchId);

}
