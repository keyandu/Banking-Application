package com.learning.BankingApplication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transaction;
import com.learning.BankingApplication.payload.request.AccountRequest;
import com.learning.BankingApplication.payload.response.AccountDetailResponse;
import com.learning.BankingApplication.payload.response.AccountResponse;
import com.learning.BankingApplication.payload.response.TransactionResponse;
import com.learning.BankingApplication.service.AccountService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class AccountController {
	@Autowired
	AccountService accoutServ;
	
	@PostMapping("/customer/{id}/create_account")
	public String create(@PathVariable long id,@Valid @RequestBody AccountRequest acctReq) {
		return accoutServ.create(id, acctReq);
	}
	
	@GetMapping("/customer/{id}/get_accounts")
	public List<AccountResponse> getAccountsByUser(@PathVariable Long id){
		List<AccountResponse> res= new ArrayList<AccountResponse>();
		List<Account> acctList = accoutServ.getAccountsByUser(id);
		for (Account account : acctList) {
			res.add(new AccountResponse(account.getAccountNo(),account.getAccountType(),account.getAccountBalance(),account.getAccountStatus()));
		}
		return res;
	}
	@GetMapping("/customer/account_details/{id}")
	public AccountDetailResponse accountDetail(@PathVariable long id){
		Account res = accoutServ.accountDetail(id);
		List<Transaction> tran = res.getTransactions();
		List<TransactionResponse> tRes = new ArrayList<TransactionResponse>();
		for (Transaction transaction : tran) {
			tRes.add(new TransactionResponse(transaction.getCreateDate(),transaction.getReference(),transaction.getAmount()));
		}
		return new AccountDetailResponse(res.getAccountNo(),res.getAccountType(),res.getAccountBalance(),
				res.getAccountStatus(),tRes);
		
	}

}
