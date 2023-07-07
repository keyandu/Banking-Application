package com.learning.BankingApplication.request;

import com.learning.BankingApplication.entity.Approved;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class ApproveAccountRequest {
	@NotNull
	@NotBlank
    private Long id;
    public String getApproveOrNot() {
		return approveOrNot;
	}
	public void setApproveOrNot(String approveOrNot) {
		this.approveOrNot = approveOrNot;
	}
	
	@NotNull
	@NotBlank
	private String approveOrNot;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	} 

  
}
