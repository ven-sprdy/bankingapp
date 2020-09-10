package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.BranchDTO;
import com.prasaddy.bankingapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/banks")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/{bankId}/branches")
    public Page<BranchDTO> getAllBranchesByBankId(@PathVariable UUID bankId, Pageable pageable) {
        return branchService.findBranchesByBankId(bankId, pageable);
    }

    @PostMapping("/{bankId}/branches/save")
    public ResponseEntity<List<BranchDTO>> createBranches(@PathVariable UUID bankId, @RequestBody List<BranchDTO> branchDTOS) {
        return branchService.createBranches(bankId, branchDTOS);
    }

    @PutMapping("/{bankId}/branches/{branchId}/update")
    public ResponseEntity<BranchDTO> updateBranchById(@PathVariable UUID bankId, @PathVariable UUID branchId, @RequestBody BranchDTO branchDTO) {
        return branchService.updateBranchById(bankId, branchId, branchDTO);
    }

    @DeleteMapping("/{bankId}/branches/{branchId}/delete")
    public ResponseEntity<String> deleteBranchById(@PathVariable UUID bankId, @PathVariable UUID branchId) {
        return branchService.deleteBranchById(bankId, branchId);
    }

}
