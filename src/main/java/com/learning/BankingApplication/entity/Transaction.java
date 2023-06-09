package com.learning.BankingApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    private Date createDate;
    private String reference;
    private double amount;
    private TransactionType transactionType;
    @ManyToOne
    private Account account;

    private Approved approved=Approved.NO;

    public Transaction() {

    }

    public Transaction(long id, Date createDate, String reference, double amount, TransactionType transactionType,
                       Account account, Approved approved) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.reference = reference;
		this.amount = amount;
		this.transactionType = transactionType;
		this.account = account;
		this.approved = approved;
	}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReference() {
        return reference;
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

	public Approved  getApproved() {
        return approved;
    }

    public void setApproved(Approved approved) {
        this.approved = approved;
    }

    public long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", reference='" + reference + '\'' +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", account=" + account +
                ", approved='" + approved + '\'' +
                '}';
    }
}
