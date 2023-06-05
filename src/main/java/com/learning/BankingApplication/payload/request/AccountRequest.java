package com.learning.BankingApplication.payload.request;

import javax.validation.constraints.NotBlank;

import com.learning.BankingApplication.entity.AccountType;

public class AccountRequest {
	@NotBlank
	private AccountType accountType;
	@NotBlank
	private double accountBalance;
	@NotBlank
	private String accountNo;
	
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
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
}
