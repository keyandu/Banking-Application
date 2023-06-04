package com.learning.BankingApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transfer {
    @Id
    @GeneratedValue
    private long transferId;

    private long fromAccountNo;

    private long toAccountNo;

    private double amount;
    @ManyToOne
    private User byCustomer;

    private Status transferStatus;

    public long getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(long fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public long getToAccountNo() {
        return toAccountNo;
    }

    public void setToAccountNo(long toAccountNo) {
        this.toAccountNo = toAccountNo;
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
