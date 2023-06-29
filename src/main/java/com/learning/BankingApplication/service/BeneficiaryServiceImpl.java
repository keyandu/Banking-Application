package com.learning.BankingApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.model.BeneficiaryInformation;
import com.learning.BankingApplication.request.ApproveBeneficiaryRequest;
import com.learning.BankingApplication.response.ApproveBeneficiaryResponse;
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
	@Override

	public List<BeneficiaryInformation> listAllBeneficiaryToBeApproved() {
		List<Beneficiary> beneficiaries =beneDAO.findBeneficiariesByApproved(Approved.NO);

		List<BeneficiaryInformation> result = new ArrayList<BeneficiaryInformation>();
		for(Beneficiary b :beneficiaries){
			BeneficiaryInformation bi = new BeneficiaryInformation();
			bi.setApproved(Approved.NO);
			bi.setBeneficiaryAcNo(b.getBeneficiaryAccountNo());
			bi.setBeneficiaryAddedDate(b.getBeneficiaryAddDate());
			bi.setFromCustomer(b.getCustomer().getId());
			result.add(bi);
		}
 		return result;
	}

	@Override
	public ApproveBeneficiaryResponse approveBeneficiaryOrNot(ApproveBeneficiaryRequest approveBeneficiaryRequest) {
		Beneficiary beneficiary = beneDAO.getById(approveBeneficiaryRequest.getBeneficiaryAcNo());
		ApproveBeneficiaryResponse response = new ApproveBeneficiaryResponse();
		if(beneficiary==null){

			return null;
		}else{
			if(approveBeneficiaryRequest.getFromCustomer()==beneficiary.getCustomer().getId()){
				beneficiary.setApproved(approveBeneficiaryRequest.getApproved());
				beneDAO.save(beneficiary);
				response.setApproved(beneficiary.getApproved());
				response.setBeneficiaryAcNo(beneficiary.getBeneficiaryAccountNo());
				response.setFromCustomer(approveBeneficiaryRequest.getFromCustomer());
				response.setBeneficiaryAddedDate(beneficiary.getBeneficiaryAddDate());
				return response;
			}
			return null;
		}

	}

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
	

}
