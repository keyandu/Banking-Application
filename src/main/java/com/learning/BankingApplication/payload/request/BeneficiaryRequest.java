package com.learning.BankingApplication.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BeneficiaryRequest {
	@NotBlank
	@Size(min = 3, max = 20)
    private String beneficiaryName;
	@NotBlank
	@Size(max = 50)
    private String accountNo;
	public BeneficiaryRequest(String beneficiaryName, String accountNo) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.accountNo = accountNo;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

}
