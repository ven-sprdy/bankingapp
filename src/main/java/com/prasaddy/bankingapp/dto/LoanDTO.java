package com.prasaddy.bankingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.model.LoanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private UUID loanId;
    private LoanType loanType;
    private BigDecimal loanAmount;
    @JsonIgnore
    private Branch branch;

}
