package com.prasaddy.bankingapp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "bank_id", columnDefinition = "BINARY(16)")
    private UUID bankId;

    @Column(name = "bank_name", nullable = false, unique = true, length = 36)
    private String bankName;

    @Column(name = "bank_code", unique = true, length = 20)
    private String bankCode;

    @Column(name = "bank_routing_number", nullable = false, unique = true)
    private long bankRoutingNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_address_id", nullable = false)
    private Address bankAddress;

}
