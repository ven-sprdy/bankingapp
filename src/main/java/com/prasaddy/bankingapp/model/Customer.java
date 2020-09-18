package com.prasaddy.bankingapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "customer_address", nullable = false)
    private Address customerAddress;

    @Column(name = "mobile_number", nullable = false, length = 12)
    private String mobileNumber;

    @Column(name = "dob", nullable = false, length = 12)
    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "customer_loan", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "loan_id"))
    private Set<Loan> loans = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "customer_account", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Set<Loan> accounts = new HashSet<>();

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = new EmailAddress(emailAddress).getEmailAddress();
    }

}
