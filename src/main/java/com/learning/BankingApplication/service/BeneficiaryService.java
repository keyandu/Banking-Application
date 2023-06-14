package com.learning.BankingApplication.service;

import com.learning.BankingApplication.model.BeneficiaryInformation;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.request.ApproveBeneficiaryRequest;
import com.learning.BankingApplication.response.ApproveBeneficiaryResponse;

import java.util.List;

public interface BeneficiaryService {
	String addBene(long userid, BeneficiaryRequest beneReq);
	List<BeneficiaryInformation> listAllBeneficiaryToBeApproved();
	ApproveBeneficiaryResponse approveBeneficiaryOrNot(ApproveBeneficiaryRequest approveBeneficiaryRequest);

}
