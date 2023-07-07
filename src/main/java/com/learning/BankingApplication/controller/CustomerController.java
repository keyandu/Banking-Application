package com.learning.BankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApplication.payload.request.UpdateCustomerReq;
import com.learning.BankingApplication.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/customer")
public class CustomerController {
	@Autowired
	UserService userService;
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody UpdateCustomerReq updateCustomer) {
		return userService.updateById(id,updateCustomer);
		
	}

}
