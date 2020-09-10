package com.prasaddy.bankingapp.service;

import com.prasaddy.bankingapp.dto.BankDTO;
import com.prasaddy.bankingapp.dto.BranchDTO;
import com.prasaddy.bankingapp.model.Bank;
import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.repository.BankRepository;
import com.prasaddy.bankingapp.repository.BranchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BranchService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BranchRepository branchRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<BranchDTO> findBranchesByBankId(UUID bankId, Pageable pageable) {
        return branchRepository.findByBankBankId(bankId, pageable).map(branch -> modelMapper.map(branch, BranchDTO.class));
    }

    public ResponseEntity<List<BranchDTO>> createBranches(UUID bankId, List<BranchDTO> branchDTOS) {
        List<BranchDTO> branches = new ArrayList<>();
        branchDTOS.forEach(branch -> {
            bankRepository.findById(bankId).map(bank -> {
                BankDTO bankDTO = modelMapper.map(bank, BankDTO.class);
                branch.setBank(bankDTO);
                Branch branchEntity = modelMapper.map(branch, Branch.class);
                Branch savedBranch =  branchRepository.save(branchEntity);
                branches.add(modelMapper.map(savedBranch, BranchDTO.class));
                return savedBranch;
            }).orElseThrow(EntityNotFoundException::new);
        });
        return ResponseEntity.ok(branches);
    }

    public ResponseEntity<BranchDTO> updateBranchById(UUID bankId, UUID branchId, BranchDTO branchDTO) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(EntityNotFoundException::new);
        Branch newBranch = modelMapper.map(branchDTO, Branch.class);
        Branch oldBranch = branchRepository.findById(branchId).orElseThrow(EntityNotFoundException::new);
        newBranch.setBranchId(oldBranch.getBranchId());
        newBranch.setBank(bank);
        Branch branch = branchRepository.save(newBranch);
        return ResponseEntity.ok(modelMapper.map(branch, BranchDTO.class));
    }

    public ResponseEntity<String> deleteAllBranchDetails() {
        branchRepository.deleteAll();
        return ResponseEntity.ok("All branch details deleted.");
    }

    public ResponseEntity<String> deleteBranchById(UUID bankId, UUID branchId) {
        Branch branch = branchRepository.findByBranchIdAndBankBankId(branchId, bankId).orElseThrow(EntityNotFoundException::new);
        branchRepository.delete(branch);
        return ResponseEntity.ok("Branch details deleted by ID: " +branchId);
    }

}