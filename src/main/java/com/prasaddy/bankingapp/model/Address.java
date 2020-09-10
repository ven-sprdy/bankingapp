package com.prasaddy.bankingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "address_line1", nullable = false, length = 36)
    private String addressLine1;

    @Column(name = "address_line2", length = 36)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 25)
    private String city;

    @Column(name = "state", nullable = false, length = 25)
    private String state;

    @Column(name = "zip", nullable = false, length = 5)
    private String zip;

}