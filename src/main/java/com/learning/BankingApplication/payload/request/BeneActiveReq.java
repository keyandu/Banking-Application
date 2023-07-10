package com.learning.BankingApplication.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;


public class BeneActiveReq {
	@NotBlank
	private String deactive;

	public String getDeactive() {
		return deactive;
	}

	public void setDeactive(String deactive) {
		this.deactive = deactive;
	}
	
}
