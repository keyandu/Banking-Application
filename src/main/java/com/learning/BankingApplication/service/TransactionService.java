package com.learning.BankingApplication.service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transaction;


public interface TransactionService {
	
	public String viewAccountStatement(Account account);
	
	public String withdrawCash(Transaction transaction);
	
	public String depositCash(Transaction transaction);
		
}
