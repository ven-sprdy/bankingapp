package com.prasaddy.bankingapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "customer_id", columnDefinition = "BINARY(16)")
    private UUID customerId;

    @Column(name = "first_name", nullable = false, length = 36)
    private String firstName;

    @Column(name = "middle_name", length = 36)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 36)
    private String lastName;

    @Column(nullable = false, unique = true, length = 36)
    private EmailAddress email;

    @Column(name = "customer_address", nullable = false)
    private Address customerAddress;

    @Column(name = "mobile_number", nullable = false, length = 12)
    private String mobileNumber;

    @Column(name = "dob", nullable = false, length = 10)
    @Temporal(TemporalType.DATE)
    private Date dob;

}
