package com.learning.BankingApplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.model.BeneficiaryInformation;
import com.learning.BankingApplication.request.ApproveBeneficiaryRequest;
import com.learning.BankingApplication.response.ApproveBeneficiaryResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.BankingApplication.entity.Beneficiary;
import com.learning.BankingApplication.entity.BeneficiaryActive;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;
import com.learning.BankingApplication.payload.response.BeneficiaryResponse;
import com.learning.BankingApplication.payload.response.MessageResponse;
import com.learning.BankingApplication.repo.BeneficiaryRepo;
import com.learning.BankingApplication.repo.UserRepo;
@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
	@Autowired
	UserRepo userDAO;



	@Autowired
	BeneficiaryRepo beneDAO;
	@Override
	public ResponseEntity<?> addBene(long userid, BeneficiaryRequest beneReq) {

		User user = userDAO.findById(userid).orElse(null);
		if(user==null) return ResponseEntity.ok(new MessageResponse("User not found"));
		List<Beneficiary> beneList = new ArrayList<Beneficiary>();
		
		beneList=user.getBeneficiary();
		Beneficiary bene = new Beneficiary(beneReq.getBeneficiaryName(), user, beneReq.getAccountNo(), new Date());
		beneDAO.save(bene);
		beneList.add(bene);
		userDAO.save(user);
		
		return ResponseEntity.ok(new MessageResponse("addBene successfully"));
	}
	@Override

	public List<BeneficiaryResponse> listAllBeneficiaryToBeApproved() {
		List<Beneficiary> beneficiaries =beneDAO.findBeneficiariesByApproved(Approved.NO);

		List<BeneficiaryResponse> result = new ArrayList<BeneficiaryResponse>();
		for(Beneficiary b :beneficiaries){
			BeneficiaryResponse bi = new BeneficiaryResponse();
			bi.setApprove(Approved.NO);
			bi.setBeneficiaryId(b.getBeneficiaryAccountNo());
			bi.setBeneficiaryAccountNo(b.getAccountNo());
			bi.setBeneficiaryAddedDate(b.getBeneficiaryAddDate());
			bi.setFromCustomerName(b.getCustomer().getUsername());
			bi.setBeneficiaryName(b.getBeneficiaryName());
			bi.setFromCustomerId(b.getCustomer().getId());
			bi.setActive(b.getActive());
			result.add(bi);
		}
 		return result;
	}

	@Override
	public ApproveBeneficiaryResponse approveBeneficiaryOrNot(ApproveBeneficiaryRequest approveBeneficiaryRequest) {
		Beneficiary beneficiary = beneDAO.findById(approveBeneficiaryRequest.getBeneficiaryAcNo()).orElse(null);
		ApproveBeneficiaryResponse response = new ApproveBeneficiaryResponse();
		//System.out.println(approveBeneficiaryRequest.getApproved());
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
		if(user==null) return null;
		List<Beneficiary> beneList = user.getBeneficiary();
		List<BeneficiaryResponse> res = new ArrayList<BeneficiaryResponse>();
		for (Beneficiary beneficiary : beneList) {
			if(beneficiary.getActive()==BeneficiaryActive.YES) {
				res.add(new BeneficiaryResponse(beneficiary.getBeneficiaryAccountNo(),beneficiary.getAccountNo(),beneficiary.getCustomer().getUsername(),beneficiary.getBeneficiaryName(),beneficiary.getCustomer().getId(),beneficiary.getActive(),beneficiary.getBeneficiaryAddDate(),beneficiary.getApproved()
						));
			}
		}
		return res;
	}
	@Override
	public String deactive(long bid, String deactive) {
		// TODO Auto-generated method stub
		Beneficiary bene = beneDAO.findById(bid).orElse(null);
		if(bene==null) {
			return "Beneficiary not found";
		}
		
		if(deactive.equals("NO")) {
			bene.setActive(BeneficiaryActive.NO);
			beneDAO.save(bene);
			return "Deactive successfully";
		}
		return "No Changes Happened";
	}
	

}
