package com.prasaddy.bankingapp.model;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "bank")
@Setter
@Getter
public class BankEntity {

    @Id
    @GeneratedValue(generator = UUIDStringGenerator.generatorName)
    @GenericGenerator(name = UUIDStringGenerator.generatorName, strategy = "com.prasaddy.bankingapp.utils.UUIDStringGenerator")
    @Column(name = "bank_id", length = 36)
    private String bankId;

    @Column(name = "bank_name", nullable = false, unique = true, length = 36)
    private String bankName;

    @Column(name = "bank_routing_number", nullable = false, unique = true)
    private long bankRoutingNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_address_id", referencedColumnName = "address_id", nullable = false)
    @RestResource(path = "bankAddress")
    private AddressEntity bankAddress;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "bankDetails")
//    @RestResource(path = "bankBranches")
    private Set<BranchEntity> branches = new HashSet<>();

}
