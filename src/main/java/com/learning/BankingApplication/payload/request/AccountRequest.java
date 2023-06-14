package com.learning.BankingApplication.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.learning.BankingApplication.entity.AccountType;

public class AccountRequest {
	//@NotBlank
	//@Pattern(regexp = "SB|CA",message = "should enter SB or CA")
	private AccountType accountType;
	//@NotBlank
	private double accountBalance;
	@NotNull
	//@NotBlank

	private String accountNo;

	public AccountRequest(AccountType accountType, double accountBalance, String accountNo) {
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
	}

	public AccountRequest() {
	}

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
