package com.learning.BankingApplication.service;


import com.learning.BankingApplication.model.BeneficiaryInformation;
import com.learning.BankingApplication.request.ApproveBeneficiaryRequest;
import com.learning.BankingApplication.response.ApproveBeneficiaryResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.payload.response.BeneficiaryResponse;

public interface BeneficiaryService {
	ResponseEntity<?> addBene(long userid, BeneficiaryRequest beneReq);
	List<BeneficiaryResponse> listAllBeneficiaryToBeApproved();
	ApproveBeneficiaryResponse approveBeneficiaryOrNot(ApproveBeneficiaryRequest approveBeneficiaryRequest);

	List<BeneficiaryResponse> getBeneByCustomer(long userid);
	String deactive(long bid, String deactive);

}
