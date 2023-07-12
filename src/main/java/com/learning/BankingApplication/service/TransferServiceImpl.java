package com.learning.BankingApplication.service;

import static com.learning.BankingApplication.entity.Status.Disable;

import java.util.List;

import javax.persistence.ManyToOne;

import com.learning.BankingApplication.payload.request.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Status;
import com.learning.BankingApplication.entity.Transfer;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.TransferRepo;

@Service
public class TransferServiceImpl implements TransferService{
	
	@Autowired
	TransferRepo transferDAO;
	
	@Autowired
	AccountRepo accountDAO;
	@Autowired
	TransactionService transactionService;
	
	public Transfer findTransferBYId( long transferId) {
		Transfer result = transferDAO.findById(transferId).orElse(null);
		return result;
	}
		
	public List<Transfer> listAllTransfers() {
		
		List<Transfer> transfers = transferDAO.findAll();
		return transfers;
	}
	
	
	public String makeTransfer(TransferRequest transferRequest) {
		// 1) check balance
		Account fromAcc = accountDAO.getById(transferRequest.getFromAccountId());
		Account toAcc=accountDAO.getById(transferRequest.getToAccountId());
		Double amount=transferRequest.getAmount();
		Double maxAmount = fromAcc.getAccountBalance();
		if (amount > maxAmount) {
			return "insufficient funds";
		}

		Transfer t1=new Transfer();
		t1.setAmount(amount);
		t1.setFromAccountNo(fromAcc.getAccountNo());
		t1.setToAccountNo(toAcc.getAccountNo());
		t1.setByCustomer(fromAcc.getOwner());


		fromAcc.setAccountBalance(fromAcc.getAccountBalance()-amount);
		toAcc.setAccountBalance(toAcc.getAccountBalance() + amount);
		accountDAO.save(fromAcc);
		accountDAO.save(toAcc);
		try {
			transactionService.depositCash(toAcc.getAccountNo(), amount, "transfer from" + fromAcc);
			transactionService.withdrawCash(fromAcc.getAccountNo(), amount, "transfer to" + fromAcc);
			transferDAO.save(t1);
			return "success";
		}catch (Exception e){
			return "transfer failed";
		}


	}
}






