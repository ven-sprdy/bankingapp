package com.prasaddy.bankingapp.relationships;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class SocialProfileController {

    @Autowired
    private  SocialAccountRepository socialAccountRepository;

    @Autowired
    private SocialProfileRepository socialProfileRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public SocialProfileDTO createSocialProfile(@RequestBody SocialProfileDTO socialProfileDTO) {
        SocialProfile socialProfile = modelMapper.map(socialProfileDTO, SocialProfile.class);
        socialProfile = socialProfileRepository.save(socialProfile);
        return modelMapper.map(socialProfile, SocialProfileDTO.class);
    }

}
