package com.learning.BankingApplication.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Beneficiary;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.payload.response.BeneficiaryResponse;
import com.learning.BankingApplication.repo.BeneficiaryRepo;
import com.learning.BankingApplication.repo.UserRepo;
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
	@Autowired
	UserRepo userDAO;
	@Autowired
	BeneficiaryRepo beneDAO;
	@Override
	public String addBene(long userid, BeneficiaryRequest beneReq) { // needs fixing, throw exception if optional returns null

		User user = userDAO.findById(userid).orElse(null); 
		List<Beneficiary> beneList = new ArrayList<Beneficiary>();
		
		beneList=user.getBeneficiary();
		Beneficiary bene = new Beneficiary(beneReq.getBeneficiaryName(), user, beneReq.getAccountNo(), new Date());
		beneDAO.save(bene);
		beneList.add(bene);
		userDAO.save(user);
		
		return "addBene successfully";
	}
	@Override
	public List<BeneficiaryResponse> getBeneByCustomer(long userid) {
		// TODO Auto-generated method stub
		User user = userDAO.findById(userid).orElse(null);
		List<Beneficiary> beneList = user.getBeneficiary();
		List<BeneficiaryResponse> res = new ArrayList<BeneficiaryResponse>();
		for (Beneficiary beneficiary : beneList) {
			res.add(new BeneficiaryResponse(beneficiary.getAccountNo(),beneficiary.getBeneficiaryName()
					,beneficiary.getActive()));
		}
		return res;
	}
	
	@Override
	public String deleteBeneficiary(long userid, BeneficiaryRequest beneReq) { 
		
		User user = userDAO.findById(userid).orElse(null);
		if (user == null) {
			return "user Benefciary does not exist";
		}
		
		else {
			List<Beneficiary> beneList = new ArrayList<Beneficiary>();
		    beneList = user.getBeneficiary();
	        
	        Beneficiary targetBeneficiary = null;
	        for (Beneficiary beneficiary : beneList) {
	            if (beneficiary.getAccountNo().equals(beneReq.getAccountNo())) {
	                targetBeneficiary = beneficiary;
	                break;
	            }
	        }
	        
	        if (targetBeneficiary != null) {
	            beneList.remove(targetBeneficiary);
	            userDAO.save(user); 
	            return "Beneficiary deleted!";
	        } else {
	            return "Beneficiary does not exist";
	        }
		}
	}
}
