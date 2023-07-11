package com.learning.BankingApplication.request;

import com.learning.BankingApplication.entity.Approved;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class ApproveAccountRequest {
	@NotNull
	@NotBlank
	private String accNo;
    public String getApproveOrNot() {
		return approveOrNot;
	}
	public void setApproveOrNot(String approveOrNot) {
		this.approveOrNot = approveOrNot;
	}
	
	@NotNull
	@NotBlank
	private String approveOrNot;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

}

  

