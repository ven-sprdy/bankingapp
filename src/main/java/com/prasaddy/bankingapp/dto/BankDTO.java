package com.prasaddy.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {

    private UUID bankId;
    private String bankName;
    private String bankCode;
    private long bankRoutingNumber;
    private AddressDTO bankAddress;

}
