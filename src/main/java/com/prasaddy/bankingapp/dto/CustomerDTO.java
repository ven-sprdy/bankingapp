package com.prasaddy.bankingapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prasaddy.bankingapp.model.Address;
import com.prasaddy.bankingapp.model.Branch;
import com.prasaddy.bankingapp.model.EmailAddress;
import com.prasaddy.bankingapp.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private UUID customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private Address customerAddress;
    private String mobileNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private Branch branch;
    private Set<Loan> loans = new HashSet<>();
    private Set<Loan> accounts = new HashSet<>();

}
