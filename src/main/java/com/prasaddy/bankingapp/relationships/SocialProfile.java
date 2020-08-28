package com.prasaddy.bankingapp.relationships;

import com.prasaddy.bankingapp.utils.UUIDStringGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class SocialProfile {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private UUID socialProfileId;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "social_profile_id")
    @MapsId
    private SocialAccount socialAccount;

}
