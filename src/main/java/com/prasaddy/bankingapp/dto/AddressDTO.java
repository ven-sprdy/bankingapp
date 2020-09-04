package com.prasaddy.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private UUID addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

}
