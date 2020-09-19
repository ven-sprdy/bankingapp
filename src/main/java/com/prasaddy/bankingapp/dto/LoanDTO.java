package com.prasaddy.bankingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prasaddy.bankingapp.model.LoanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private UUID loanId;
    private LoanType loanType;
    private BigDecimal loanAmount;
    @JsonIgnore
    private BranchDTO branch;
    @JsonIgnore
    private Set<CustomerDTO> customerDTOs = new HashSet<>();

}
