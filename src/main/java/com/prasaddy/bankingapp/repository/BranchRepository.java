package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.BranchEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchRepository extends JpaRepository<BranchEntity, String> {

//    Page<BranchEntity> findByBankId(String bankId, Pageable pageable);
//    Optional<BranchEntity> findByIdAndBranchId(String bankId, String branchId);

}
