package com.prasaddy.bankingapp.relationships;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialAccountRepository extends JpaRepository<SocialAccount, UUID> {
}
