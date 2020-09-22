package com.prasaddy.bankingapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class BankingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappApplication.class, args);
//		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BankingappApplication.class, args);
//		SocialAccountRepository socialAccountRepository = configurableApplicationContext.getBean(SocialAccountRepository.class);
//		SocialProfileRepository socialProfileRepository = configurableApplicationContext.getBean(SocialProfileRepository.class);
	}

}
