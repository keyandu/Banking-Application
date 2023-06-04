package com.learning.BankingApplication.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private long accountNo;
    private AccountType accountType;
    private double accountBalance;
    private String approved;
    @ManyToOne
    private User owner;
    private Date createDate;
    private Status accountStatus;
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

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
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

    public long getAccountNo() {
        return accountNo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", approved='" + approved + '\'' +
                ", owner=" + owner +
                ", createDate=" + createDate +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
