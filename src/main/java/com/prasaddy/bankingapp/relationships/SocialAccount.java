package com.prasaddy.bankingapp.relationships;

import com.prasaddy.bankingapp.model.EmailAddress;
import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class SocialAccount {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private UUID socialAccountId;

    @Column(unique = true)
    private EmailAddress email;

    private String password;

}
