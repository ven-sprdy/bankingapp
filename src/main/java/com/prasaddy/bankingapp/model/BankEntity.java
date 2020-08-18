package com.prasaddy.bankingapp.model;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bank")
public class BankEntity {

    @Id
    @GeneratedValue(generator = UUIDStringGenerator.generatorName)
    @GenericGenerator(name = UUIDStringGenerator.generatorName, strategy = "com.prasaddy.bankingapp.utils.UUIDStringGenerator")
    @Column(name = "bank_id", length = 36)
    private String bankId;

    @Column(name = "bank_name", nullable = false, unique = true, length = 36)
    private String bankName;

    @Column(name = "routing_number", nullable = false, unique = true)
    private long routingNumber;

}
