package com.learning.BankingApplication.model;

import com.learning.BankingApplication.entity.AccountType;
import com.learning.BankingApplication.entity.Approved;

import java.util.Date;

public class AccountInformation {
    private AccountType accType;
    private String customerName;
    private Long accNo;
    private Date dateCreated;
    private Approved approved;

    public AccountInformation(AccountType accType, String customerName, Long accNo, Date dateCreated, Approved approved) {
        this.accType = accType;
        this.customerName = customerName;
        this.accNo = accNo;
        this.dateCreated = dateCreated;
        this.approved = approved;
    }

    public AccountInformation() {
    }

    public AccountType getAccType() {
        return accType;
    }

    public void setAccType(AccountType accType) {
        this.accType = accType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Approved getApproved() {
        return approved;
    }

    public void setApproved(Approved approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "AccountInformation{" +
                "accType='" + accType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", accNo=" + accNo +
                ", dateCreated=" + dateCreated +
                ", approved=" + approved +
                '}';
    }
}
