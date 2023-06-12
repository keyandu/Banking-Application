package com.learning.BankingApplication.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.math.BigInteger;
import java.util.UUID;
@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;
    

    private String accountNo;

    private AccountType accountType;
    private double accountBalance;

    private Approved approved;

    @ManyToOne
    private User owner;
    private Date createDate;
    private Status accountStatus=Status.Disable; //How to use this attribute? What is difference between account status and approve
    public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany
    private List<Transaction> transactions;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Approved getApproved() {
        return approved;
    }

    public void setApproved(Approved approved) {
        this.approved = approved;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Status getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public String getAccountNo() {
        return accountNo;
    }
    public long getId() {
    	return this.id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", accountStatus=" + accountStatus +
                '}';
    }

	public Account(AccountType accountType, double accountBalance,User owner,
			Date createDate) {
		super();
		String generateUUIDNo = String.format("%010d",new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
		 
        // To decide length of unique positive long number
        // generateUUIDNo.length() - uniqueNoSize is being
        // used
        String unique_no = generateUUIDNo.substring( generateUUIDNo.length() - 12);
        System.out.println(unique_no);
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.owner = owner;
		this.createDate = createDate;
		this.transactions = new ArrayList<Transaction>();
		this.approved = Approved.NO;
		this.accountNo=unique_no;
		
	}


}
