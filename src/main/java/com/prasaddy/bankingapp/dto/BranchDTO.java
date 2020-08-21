package com.prasaddy.bankingapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

    private String branchId;
    private String branchName;
    private String branchTelephoneNumber;
    private AddressDTO branchAddress;
    @JsonIgnore
    private BankDTO bank;

}
