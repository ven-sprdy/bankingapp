package com.prasaddy.bankingapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "transaction_id", columnDefinition = "BINARY(16)")
    private UUID transactionId;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "date_of_transaction", nullable = false)
    private LocalDateTime dateOfTransaction;

    @Column(name = "medium_of_transaction", nullable = false, length = 25)
    private String  mediumOfTransaction;

    @Column(name = "transaction_type", nullable = false, length = 15)
    private String transactionType;

    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;

}
