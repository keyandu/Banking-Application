package com.learning.BankingApplication.security.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.PasswordResetToken;
import com.learning.BankingApplication.repo.PasswordTokenRepo;
@Service
public class SecurityUserServiceImpl implements SecurityUserService{
	@Autowired
	PasswordTokenRepo passwordTokenRepository;
	
	@Override
	public String validatePasswordResetToken(PasswordResetToken passToken) {
		
		
	    return !isTokenFound(passToken) ? "invalidToken"
//	            : isTokenExpired(passToken) ? "expired"
	            : null;
	}
	private boolean isTokenFound(PasswordResetToken passToken) {
	    return passToken != null;
	}

	private boolean isTokenExpired(PasswordResetToken passToken) {
	    final Calendar cal = Calendar.getInstance();
	    return passToken.getExpiryDate().before(cal.getTime());
	}

}
