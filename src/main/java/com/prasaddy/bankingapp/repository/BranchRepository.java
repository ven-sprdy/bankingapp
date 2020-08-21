package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, String> {

//    Page<Branch> findByBankId(String bankId, Pageable pageable);
//    Optional<BranchEntity> findByIdAndBranchId(String bankId, String branchId);

}
