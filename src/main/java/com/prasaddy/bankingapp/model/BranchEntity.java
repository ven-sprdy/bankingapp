package com.prasaddy.bankingapp.model;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    @Column(name = "branch_telephone_number", nullable = false, length = 12)
    private String branchTelephoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_address_id", referencedColumnName = "address_id")
    @RestResource(path = "branchAddress")
    private AddressEntity branchAddress;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;

}
