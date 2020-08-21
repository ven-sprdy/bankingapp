package com.prasaddy.bankingapp.model;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(generator = UUIDStringGenerator.generatorName)
    @GenericGenerator(name = UUIDStringGenerator.generatorName, strategy = "com.prasaddy.bankingapp.utils.UUIDStringGenerator")
    @Column(name = "branch_id", length = 36)
    private String branchId;

    @Column(name = "branch_name", nullable = false, length = 36)
    private String branchName;

    @Column(name = "branch_telephone_number", nullable = false, length = 12)
    private String branchTelephoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_address_id", referencedColumnName = "address_id", nullable = false)
    private Address branchAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bank bank;

}
