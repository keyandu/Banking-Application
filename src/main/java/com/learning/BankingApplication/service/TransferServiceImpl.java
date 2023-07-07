package com.learning.BankingApplication.service;

import static com.learning.BankingApplication.entity.Status.Disable;

import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.Transfer;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.TransferRepo;

@Service
public class TransferServiceImpl {
	
	@Autowired
	TransferRepo transferDAO;
	
	@Autowired
	AccountRepo accountDAO;
	
	public Transfer findTransferBYId( long transferId) {
		Transfer result = transferDAO.findById(transferId).orElse(null);
		return result;
	}
		
	public List<Transfer> listAllTransfers(Account account) {
		
		List<Transfer> transfers = transferDAO.findByFromAccountNo(account.getAccountNo());
		return transfers;
	}
	
	
	public String makeTransfer(Account fromAcc, Account toAcc, double amount) {
		// 1) check balance
		Double maxAmount = fromAcc.getAccountBalance();
		if (amount > maxAmount)
				return "insufficient funds";
		
		Transfer t = new Transfer(1, fromAcc.getAccountNo(), toAcc.getAccountNo(), amount, fromAcc.getOwner(), Disable);
		fromAcc.setAccountBalance(fromAcc.getAccountBalance() - amount);
		//annotation @Transactional
		//try catch block to check
		//there should be roll back function that will reverse the transaction and set the account balance to the 
		//actual account balance
		toAcc.setAccountBalance(toAcc.getAccountBalance() + amount);
		accountDAO.save(fromAcc);
		accountDAO.save(toAcc);
		transferDAO.save(t);
		return "made transfer";
	}
}






