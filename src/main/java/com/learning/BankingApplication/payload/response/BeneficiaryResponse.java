package com.learning.BankingApplication.payload.response;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.entity.BeneficiaryActive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryResponse {
	
//	@Length(12)
	private long beneficiaryId;
	
	private String beneficiaryAccountNo;
	
	private String fromCustomerName;
	
	private String beneficiaryName;
	
	private long fromCustomerId;
	
	private BeneficiaryActive active;
	
	private Date beneficiaryAddedDate;
	
	private Approved approve;
	
}
