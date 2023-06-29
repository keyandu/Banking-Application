package com.learning.BankingApplication.security.service;

import com.learning.BankingApplication.entity.PasswordResetToken;

public interface SecurityUserService {
	public String validatePasswordResetToken(PasswordResetToken token);
}
