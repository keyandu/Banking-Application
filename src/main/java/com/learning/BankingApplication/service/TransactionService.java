package com.learning.BankingApplication.service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transaction;

import java.util.List;


public interface TransactionService {
	
	public List<Transaction> viewAccountStatement(String accountNo);
	
	public String withdrawCash(String toAcc,double amount,String reference);
	
	public String depositCash(String toAcc,double amount,String reference);
		
}
