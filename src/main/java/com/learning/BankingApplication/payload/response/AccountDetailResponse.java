package com.learning.BankingApplication.payload.response;

import java.util.List;

import com.learning.BankingApplication.entity.AccountType;
import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.Transaction;

public class AccountDetailResponse {
	private String accountNo;
    private AccountType accountType;
    public String getAccountNo() {
		return accountNo;
	}
	public AccountDetailResponse(String accountNo, AccountType accountType, double accountBalance, Status accountStatus,
			List<TransactionResponse> transactions) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountStatus = accountStatus;
		this.transactions = transactions;
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
	public List<TransactionResponse> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionResponse> transactions) {
		this.transactions = transactions;
	}
	private double accountBalance;
    private Status accountStatus; //How to use this attribute? What is difference between account status and approve
    private List<TransactionResponse> transactions;
}
