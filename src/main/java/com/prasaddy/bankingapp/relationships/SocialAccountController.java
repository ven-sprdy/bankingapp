package com.prasaddy.bankingapp.relationships;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class SocialAccountController {

    @Autowired
    private SocialAccountRepository socialAccountRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public SocialAccountDTO createSocialAccount(@RequestBody SocialAccountDTO socialAccountDTO) {
        SocialAccount socialAccount = modelMapper.map(socialAccountDTO, SocialAccount.class);
        socialAccount = socialAccountRepository.save(socialAccount);
        return modelMapper.map(socialAccount, SocialAccountDTO.class);
    }

}
