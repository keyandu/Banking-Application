package com.learning.BankingApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.payload.request.AccountRequest;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.UserRepo;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	UserRepo userDAO;
	@Autowired
	AccountRepo accountDAO;
	@Override
	public String create(long userid, AccountRequest c) {
		// TODO Auto-generated method stub
		User user = userDAO.findById(userid).orElse(null);
		System.out.println("find user");
		
		Account acct = new Account(c.getAccountNo(),c.getAccountType(),c.getAccountBalance(),user,new Date());
		accountDAO.save(acct);
		System.out.println("account created");
		
		List<Account> lisAcct = user.getAccounts();
		if(lisAcct ==null) lisAcct=new ArrayList<Account>();
		System.out.println("account gets");
		lisAcct.add(acct);
		
		user.setAccounts(lisAcct);
		System.out.println("account sets");
		userDAO.save(user);
		System.out.println("user saved");
		return "created your account";
	}
	
}
