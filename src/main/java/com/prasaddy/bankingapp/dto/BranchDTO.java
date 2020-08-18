package com.prasaddy.bankingapp.dto;

import lombok.Data;

@Data
public class BranchDTO {

    private String branchId;
    private String branchName;
    private String telephoneNumber;
    private BankDTO bank;
    private AddressDTO address;

}
