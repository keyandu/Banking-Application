package com.learning.BankingApplication.payload.request;

import javax.validation.constraints.NotBlank;

import com.learning.BankingApplication.entity.AccountType;

public class AccountRequest {
	@NotBlank
	private AccountType accountType;
	@NotBlank
	private double accountBalance;
	
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
