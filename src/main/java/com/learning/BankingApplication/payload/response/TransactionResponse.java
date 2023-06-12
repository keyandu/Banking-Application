package com.learning.BankingApplication.payload.response;

import java.util.Date;

public class TransactionResponse {
	private Date createDate;
    private String reference;
    private double amount;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getReference() {
		return reference;
	}
	public TransactionResponse(Date createDate, String reference, double amount) {
		super();
		this.createDate = createDate;
		this.reference = reference;
		this.amount = amount;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
