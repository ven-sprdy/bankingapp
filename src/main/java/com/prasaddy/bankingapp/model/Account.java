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
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "account_number", columnDefinition = "BINARY(16)")
    private UUID accountNumber;

    @Column(name = "customer_id", nullable = false, length = 36)
    private String customerId;

    @Column(name = "branch_id", nullable = false, length = 36)
    private String branchId;

    @Column(name = "opening_balance", nullable = false, length = 36)
    private BigDecimal openingBalance;

    @Column(name = "account_opening_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date accountOpeningDate;

    @Column(name = "account_type", nullable = false, length = 36)
    private String accountType;

    @Column(name = "account_status", nullable = false, length = 25)
    private String accountStatus;

}
