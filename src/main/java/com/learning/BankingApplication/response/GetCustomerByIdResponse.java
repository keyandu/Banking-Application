package com.learning.BankingApplication.response;

import com.learning.BankingApplication.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public class GetCustomerByIdResponse {
    private long customerId;
    private String customerName;
    private Status status;
    private Date createDate;
	public GetCustomerByIdResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetCustomerByIdResponse(long customerId, String customerName, Status status, Date createDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.status = status;
		this.createDate = createDate;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "GetCustomerByIdResponse [customerId=" + customerId + ", customerName=" + customerName + ", status="
				+ status + ", createDate=" + createDate + "]";
	}
    
    

}


