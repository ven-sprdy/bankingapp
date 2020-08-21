package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.BranchDTO;
import com.prasaddy.bankingapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/{bankId}/branches")
    public Page<BranchDTO> getAllBranchesByBankId(@PathVariable String bankId, Pageable pageable) {
        return branchService.findBranchesByBankId(bankId, pageable);
    }

    @PostMapping("/{bankId}/branches")
    public void createBranches(@PathVariable String bankId, @RequestBody List<BranchDTO> branchDTOS) {
        branchService.createBranches(bankId, branchDTOS);
    }

    @PutMapping("/{bankId}/branches/{branchId}")
    public void updateBranchById(@PathVariable String bankId, @PathVariable String branchId, @RequestBody BranchDTO branchDTO) {
        branchService.updateBranchById(bankId, branchId, branchDTO);
    }

    @DeleteMapping("/{bankId}/branches/{branchId}")
    public void deleteBranchById(@PathVariable String bankId, @PathVariable String branchId) {
        branchService.deleteBranchById(bankId, branchId);
    }

}
