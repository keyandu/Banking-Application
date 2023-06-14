package com.learning.BankingApplication.payload.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




import com.learning.BankingApplication.entity.BeneficiaryActive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryResponse {
	@NotBlank
//	@Length(12)
	private String accountNo;
	@NotBlank
	private String beneficiaryName;
	@NotNull
	private BeneficiaryActive active;
}
