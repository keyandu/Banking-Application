package com.learning.BankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApplication.payload.request.AccountRequest;
import com.learning.BankingApplication.service.AccountService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class AccountController {
	@Autowired
	AccountService accoutServ;
	
	@PostMapping("/customer/{id}/account")
	public String create(@PathVariable long id, @RequestBody AccountRequest acctReq) {
		return accoutServ.create(id, acctReq);
	}
}
