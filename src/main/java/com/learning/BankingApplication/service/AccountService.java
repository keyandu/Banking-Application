package com.learning.BankingApplication.service;

import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.payload.request.AccountRequest;
//@Service
public interface AccountService {
	public String create(long userid, AccountRequest accountReq);
}
