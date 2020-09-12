package com.prasaddy.bankingapp.controller;

import com.prasaddy.bankingapp.dto.LoanDTO;
import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.model.Loan;
import com.prasaddy.bankingapp.repository.BranchRepository;
import com.prasaddy.bankingapp.repository.LoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private LoanRepository loanRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping(value = "/save")
    public ResponseEntity<LoanDTO> createLoan(@RequestBody LoanDTO loanDTO, @RequestHeader("branch-id") UUID branchId) {
        Branch branch = branchRepository.findById(branchId).orElseThrow(EntityNotFoundException::new);
        Loan loan = modelMapper.map(loanDTO, Loan.class);
        loan.setBranch(branch);
        loan = loanRepository.save(loan);
        return ResponseEntity.ok(modelMapper.map(loan, LoanDTO.class));
    }

}
