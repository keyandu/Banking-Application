package com.learning.BankingApplication.service;

import java.util.Date;
import java.util.List;

import com.learning.BankingApplication.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepo transactionDAO;

	@Autowired
	AccountRepo accountDAO;

	@Override
	public List<Transaction> viewAccountStatement(String accountNo) { /* list all transasctions */
		Account account = accountDAO.getAccountByAccountNo(accountNo).orElse(null);
		List<Transaction> transactions = account.getTransactions();


		return transactions;
	}


	@Override
	public String withdrawCash(String toAcc, double amount, String reference) {
		Account account = accountDAO.getAccountByAccountNo(toAcc).orElse(null);
		if (account.getAccountBalance() <= amount) {
			return "balance not enough";
		}
		if (account.getAccountStatus() == Status.Disable) {
			return "The Account is disable";
		}
		try {
			Transaction t1 = new Transaction();
			t1.setAccount(account);
			t1.setAmount(amount);
			t1.setTransactionType(TransactionType.DB);
			t1.setApproved(Approved.YES);
			t1.setReference(reference);
			t1.setCreateDate(new Date());

			account.setAccountBalance(account.getAccountBalance() - amount);
			accountDAO.save(account);
			transactionDAO.save(t1);
			return "success";
		} catch (Exception e) {
			return "failed";
		}

	}

	@Override
	public String depositCash(String toAcc, double amount, String reference) {
		Account account = accountDAO.getAccountByAccountNo(toAcc).orElse(null);
		if (account.getAccountStatus() == Status.Disable) {
			return "The Account is disable";
		}
		try {
			Transaction t1 = new Transaction();
			t1.setAccount(account);
			t1.setAmount(amount);
			t1.setTransactionType(TransactionType.DB);
			t1.setApproved(Approved.YES);
			t1.setReference(reference);
			t1.setCreateDate(new Date());

			account.setAccountBalance(account.getAccountBalance() + amount);
			accountDAO.save(account);
			transactionDAO.save(t1);
			return "success";
		} catch (Exception e) {
			return "failed";
		}

	}
}
