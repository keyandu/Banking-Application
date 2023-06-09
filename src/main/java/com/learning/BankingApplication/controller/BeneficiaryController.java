package com.learning.BankingApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApplication.payload.request.BeneActiveReq;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.payload.response.BeneficiaryResponse;
import com.learning.BankingApplication.payload.response.MessageResponse;
import com.learning.BankingApplication.service.BeneficiaryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api")
public class BeneficiaryController {
	@Autowired
	BeneficiaryService beneServ;
	@PostMapping("/customer/{id}/add_beneficiary")
	public ResponseEntity<?> addBene(@Valid @PathVariable long id, @RequestBody BeneficiaryRequest beneReq) {
		return beneServ.addBene(id, beneReq);
	}
	//get beneficiary by customer, input a customer userid from url
	@GetMapping("/customer/{userid}/get_beneficiary")
	public ResponseEntity<?> getBeneByCustomer(@PathVariable long userid) {
		List<BeneficiaryResponse> res = beneServ.getBeneByCustomer(userid);
		if(res==null) return ResponseEntity.ok(new MessageResponse("User not found"));
		return ResponseEntity.ok(res);
	}
	@PutMapping("/customer/deactive_bene/{bid}")
	public ResponseEntity<?> deactive(@PathVariable long bid, @RequestBody BeneActiveReq deactive){
		String res = beneServ.deactive(bid,deactive.getDeactive());
		return ResponseEntity.ok(new MessageResponse(res));
	}
	



}
