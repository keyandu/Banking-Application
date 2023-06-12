package com.learning.BankingApplication.request;

import com.learning.BankingApplication.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ChangeCustomerStatusRequest {
	
	
    private long customerId;
    @NotNull
    @NotBlank
    @Pattern(regexp = "Enable|Disable",message = "should enter Enable or Disable")
    private Status status;
	public ChangeCustomerStatusRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChangeCustomerStatusRequest(long customerId,
			@NotNull @NotBlank @Pattern(regexp = "Enable|Disable", message = "should enter Enable or Disable") Status status) {
		super();
		this.customerId = customerId;
		this.status = status;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ChangeCustomerStatusRequest [customerId=" + customerId + ", status=" + status + "]";
	}
    
}
