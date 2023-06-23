package com.learning.BankingApplication.service;

import java.util.List;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transfer;

public interface TransferService {
	public Transfer findTransferBYId( long transferId);
	
	public List<Transfer> listAllTransfers(Account account);
	
	public String makeTransfer(Account fromAcc, Account toAcc, double amount);
}
