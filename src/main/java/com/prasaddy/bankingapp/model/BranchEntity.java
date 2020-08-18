package com.prasaddy.bankingapp.model;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "branch")
public class BranchEntity {

    @Id
    @GeneratedValue(generator = UUIDStringGenerator.generatorName)
    @GenericGenerator(name = UUIDStringGenerator.generatorName, strategy = "com.prasaddy.bankingapp.utils.UUIDStringGenerator")
    @Column(name = "branch_id", length = 36)
    private String branchId;

    @Column(name = "branch_name", nullable = false, length = 36)
    private String branchName;

    @Column(name = "address_line1", nullable = false, length = 36)
    private String addressLine1;

    @Column(name = "address_line2", length = 36)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 25)
    private String city;

    @Column(name = "state", nullable = false, length = 25)
    private String state;

    @Column(name = "zip", nullable = false, length = 5)
    private int zip;

    @Column(name = "telephone_number", nullable = false, length = 12)
    private String telephoneNumber;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bankEntity;

}
