package com.prasaddy.bankingapp.model;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
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

@Data
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(generator = UUIDStringGenerator.generatorName)
    @GenericGenerator(name = UUIDStringGenerator.generatorName, strategy = "com.prasaddy.bankingapp.utils.UUIDStringGenerator")
    @Column(name = "account_number", length = 36)
    private String accountNumber;

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
