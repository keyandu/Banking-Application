package com.learning.BankingApplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApplication.payload.request.AccountRequest;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
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

}
