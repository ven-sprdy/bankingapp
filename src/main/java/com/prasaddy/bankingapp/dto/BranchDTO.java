package com.prasaddy.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {

    private String branchId;
    private String branchName;
    private String branchTelephoneNumber;
    private BankDTO bank;
    private AddressDTO bankAddress;

}
