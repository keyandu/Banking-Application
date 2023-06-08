package com.learning.BankingApplication.service;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Beneficiary;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.repo.BeneficiaryRepo;
import com.learning.BankingApplication.repo.UserRepo;
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
	@Autowired
	UserRepo userDAO;
	@Autowired
	BeneficiaryRepo beneDAO;
	@Override
	public String addBene(long userid, BeneficiaryRequest beneReq) {

		User user = userDAO.findById(userid).orElse(null);
		List<Beneficiary> beneList = new ArrayList<Beneficiary>();
		
		beneList=user.getBeneficiary();
		Beneficiary bene = new Beneficiary(beneReq.getBeneficiaryName(), user, beneReq.getAccountNo(), new Date());
		beneDAO.save(bene);
		beneList.add(bene);
		userDAO.save(user);
		
		return "addBene successfully";
	}
	
}
