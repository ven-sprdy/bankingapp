package com.prasaddy.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {

    private String bankId;
    private String bankName;
    private String bankCode;
    private long bankRoutingNumber;
    private AddressDTO bankAddress;

}
