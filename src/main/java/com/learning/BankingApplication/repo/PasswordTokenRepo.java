package com.learning.BankingApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.BankingApplication.entity.PasswordResetToken;
import com.learning.BankingApplication.entity.User;

@Repository
public interface PasswordTokenRepo extends JpaRepository<PasswordResetToken,Long> {

	PasswordResetToken findByToken(String token);

	
}
