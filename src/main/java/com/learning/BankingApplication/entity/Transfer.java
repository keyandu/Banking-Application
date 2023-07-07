package com.learning.BankingApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import static com.learning.BankingApplication.entity.Status.Disable;

@Entity
public class Transfer {
    @Id
    @GeneratedValue
    private long transferId;

    private String fromAccountNo;

    private String toAccountNo;

    private double amount;

    @ManyToOne
    private User byCustomer;

    private Status transferStatus=Disable;

    public String getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(String fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public String getToAccountNo() {
        return toAccountNo;
    }

    public void setToAccountNo(String toAccountNo) {
        this.toAccountNo = toAccountNo;
    }

    public Transfer(long transferId, String fromAccountNo, String toAccountNo, double amount, User byCustomer,
			Status transferStatus) {
		super();
		this.transferId = transferId;
		this.fromAccountNo = fromAccountNo;
		this.toAccountNo = toAccountNo;
		this.amount = amount;
		this.byCustomer = byCustomer;
		this.transferStatus = transferStatus;
	}

	public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getByCustomer() {
        return byCustomer;
    }

    public void setByCustomer(User byCustomer) {
        this.byCustomer = byCustomer;
    }

    public Status getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Status transferStatus) {
        this.transferStatus = transferStatus;
    }

    public long getTransferId() {
        return transferId;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", fromAccountNo=" + fromAccountNo +
                ", toAccountNo=" + toAccountNo +
                ", amount=" + amount +
                ", byCustomer=" + byCustomer +
                ", transferStatus=" + transferStatus +
                '}';
    }
}
