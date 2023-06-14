package com.learning.BankingApplication.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.learning.BankingApplication.model.AccountInformation;
import com.learning.BankingApplication.request.ApproveAccountRequest;
import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.payload.request.AccountRequest;


public interface AccountService {
	public String create(long userid, AccountRequest accountReq);

	public List<Account> getAccountsByUser(Long id);

	public Account accountDetail(long id);

	public List<AccountInformation> findAllAccountToBeApproved();
  
	public List<AccountInformation> listAllAccount();
  
	public boolean approveAccount(ApproveAccountRequest approveAccountRequest);
	

}
