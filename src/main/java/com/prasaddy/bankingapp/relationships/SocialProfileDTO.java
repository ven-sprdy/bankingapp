package com.prasaddy.bankingapp.relationships;

import lombok.Data;

@Data
public class SocialProfileDTO {

    private String socialProfileId;
    private String firstName;
    private String lastName;
    private SocialAccountDTO socialAccount;
}
