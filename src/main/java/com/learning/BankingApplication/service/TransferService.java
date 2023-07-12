package com.learning.BankingApplication.service;

import java.util.List;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transfer;
import com.learning.BankingApplication.payload.request.TransferRequest;

public interface TransferService {
	public Transfer findTransferBYId( long transferId);
	
	public List<Transfer> listAllTransfers();
	
	public String makeTransfer(TransferRequest transferRequest);
}
