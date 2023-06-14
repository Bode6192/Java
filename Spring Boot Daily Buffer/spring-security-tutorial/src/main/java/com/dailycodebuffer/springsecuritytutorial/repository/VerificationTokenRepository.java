package com.dailycodebuffer.springsecuritytutorial.repository;

import com.dailycodebuffer.springsecuritytutorial.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);
}
