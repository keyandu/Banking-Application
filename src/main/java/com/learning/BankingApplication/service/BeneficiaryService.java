package com.learning.BankingApplication.service;

import com.learning.BankingApplication.payload.request.BeneficiaryRequest;

public interface BeneficiaryService {
	String addBene(long userid, BeneficiaryRequest beneReq);

}
