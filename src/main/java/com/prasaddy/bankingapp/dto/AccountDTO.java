package com.prasaddy.bankingapp.dto;

import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private UUID accountNumber;
    private String accountType;
    private String accountStatus;
    private BigDecimal openingBalance;
    private Date accountOpeningDate;
    private Set<Customer> customers = new HashSet<>();
    private Branch branch;

}
