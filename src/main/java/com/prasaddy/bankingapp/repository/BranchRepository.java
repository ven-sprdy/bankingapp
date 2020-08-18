package com.prasaddy.bankingapp.repository;

import com.prasaddy.bankingapp.model.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BranchRepository extends JpaRepository<BranchEntity, String> {
}
