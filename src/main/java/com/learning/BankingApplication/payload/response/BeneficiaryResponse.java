package com.learning.BankingApplication.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




import com.learning.BankingApplication.entity.BeneficiaryActive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class BeneficiaryResponse {
	@NotBlank
//	@Length(12)
	private String accountNo;
	@NotBlank
	private String beneficiaryName;
	@NotNull
	private BeneficiaryActive active;
	public BeneficiaryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BeneficiaryResponse(@NotBlank String accountNo, @NotBlank String beneficiaryName,
			@NotNull BeneficiaryActive active) {
		super();
		this.accountNo = accountNo;
		this.beneficiaryName = beneficiaryName;
		this.active = active;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public BeneficiaryActive getActive() {
		return active;
	}
	public void setActive(BeneficiaryActive active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "BeneficiaryResponse [accountNo=" + accountNo + ", beneficiaryName=" + beneficiaryName + ", active="
				+ active + "]";
	}
	
	
}
