package com.prasaddy.bankingapp.relationships;

import com.prasaddy.bankingapp.model.EmailAddress;
import lombok.Data;

@Data
public class SocialAccountDTO {

    private String socialAccountId;
    private String email;
    private String password;

}
