package com.learning.BankingApplication.payload.response;

import com.learning.BankingApplication.entity.AccountType;
import com.learning.BankingApplication.entity.Status;

public class AccountResponse {
	private String accountNo;
    private AccountType accountType;
    private double accountBalance;
    
    private Status accountStatus; //How to use this attribute? What is difference between account status and approve

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

	public Status getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Status accountStatus) {
		this.accountStatus = accountStatus;
	}

	public AccountResponse(String accountNo, AccountType accountType, double accountBalance, Status accountStatus) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountStatus = accountStatus;
	}



    
    
    
}
