package com.learning.BankingApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transaction;
import com.learning.BankingApplication.entity.TransactionType;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transactionDAO;
	
	@Autowired
	AccountRepo accountDAO;
	
	@Override
	public String viewAccountStatement(Account account) { /* list all transasctions */		
		List<Transaction> transactions = account.getTransactions();
		StringBuilder statementBuilder = new StringBuilder();

		for(Transaction transaction : transactions) {
			statementBuilder.append("Account Statement for account number: ").append(account.getAccountNo()).append("\n");
			statementBuilder.append("Transaction ID: ").append(transaction.getId()).append("\n");
			statementBuilder.append("Transaction Type: ").append(transaction.getTransactionType()).append("\n");
			statementBuilder.append("Date: ").append(transaction.getCreateDate()).append("\n");
		    statementBuilder.append("Amount: ").append(transaction.getAmount()).append("\n");
		    }
		return statementBuilder.toString();
	}

	
	@Override
	public String withdrawCash(Transaction transaction) {
		if (transaction.getTransactionType()  == TransactionType.DB) {
			Transaction t = new Transaction(transaction.getId(),
			transaction.getCreateDate(), transaction.getReference(), transaction.getAmount(), 
			transaction.getTransactionType(), transaction.getAccount(), transaction.getApproved());
			
			Account acc = transaction.getAccount();
			double curr = acc.getAccountBalance();
			curr -= transaction.getAmount();
			acc.setAccountBalance(curr);
			accountDAO.save(acc);
			transactionDAO.save(t);
			return "debit withdraw saved!";
		}
				
		return "invalid transaction type!"; 
	}

	@Override
	public String depositCash(Transaction transaction) {
		if (transaction.getTransactionType()  == TransactionType.DB) {
			Transaction t = new Transaction(transaction.getId(),
			transaction.getCreateDate(), transaction.getReference(), transaction.getAmount(), 
			transaction.getTransactionType(), transaction.getAccount(), transaction.getApproved());
					
			Account acc = transaction.getAccount();
			double curr = acc.getAccountBalance();
			curr += transaction.getAmount();
			acc.setAccountBalance(curr);
			accountDAO.save(acc);
			transactionDAO.save(t);
			return "debit deposit saved!";
		}
				
		return "invalid transaction type!"; 
	 }
}
