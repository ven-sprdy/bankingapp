package com.prasaddy.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {

    private String bankId;
    private String bankName;
    private long routingNumber;
    private AddressDTO address;
    private Set<BranchDTO> branches;

}
