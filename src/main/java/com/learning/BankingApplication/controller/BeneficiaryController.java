package com.learning.BankingApplication.controller;

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


import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.payload.response.BeneficiaryResponse;
import com.learning.BankingApplication.service.BeneficiaryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class BeneficiaryController {
	@Autowired
	BeneficiaryService beneServ;
	@PostMapping("/customer/{id}/add_beneficiary")
	public String addBene(@Valid @PathVariable long id, @RequestBody BeneficiaryRequest beneReq) {
		return beneServ.addBene(id, beneReq);
	}
	//get beneficiary by customer, input a customer userid from url
	@GetMapping("/customer/{userid}/get_beneficiary")
	public List<BeneficiaryResponse> getBeneByCustomer(@PathVariable long userid) {
		
		return beneServ.getBeneByCustomer(userid);
	}
	



}
