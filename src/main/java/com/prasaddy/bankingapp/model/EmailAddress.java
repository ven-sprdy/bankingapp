package com.prasaddy.bankingapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@Embeddable
public class EmailAddress {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    @Column(name = "email")
    private String email;

    public EmailAddress(String emailAddress) {
        Assert.isTrue(isValid(emailAddress), "Invalid email address!");
        this.email = emailAddress;
    }

    public static boolean isValid(String candidate) {
        return candidate != null && PATTERN.matcher(candidate).matches();
    }

//    @Override
//    public String toString() {
//        return value;
//    }

}
