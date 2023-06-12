package com.learning.BankingApplication.service;

import java.util.List;

import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.payload.response.BeneficiaryResponse;

public interface BeneficiaryService {
	String addBene(long userid, BeneficiaryRequest beneReq);
	List<BeneficiaryResponse> getBeneByCustomer(long userid);
    String deleteBeneficiary(long userid, BeneficiaryRequest beneReq); //newly Added

}
