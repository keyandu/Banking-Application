package com.learning.BankingApplication.model;

import com.learning.BankingApplication.entity.Approved;

import java.util.Date;

public class BeneficiaryInformation {
    private long fromCustomer;
    private long beneficiaryAcNo;
    private Date beneficiaryAddedDate;
    private Approved approved;

    public BeneficiaryInformation(long fromCustomer, long beneficiaryAcNo, Date beneficiaryAddedDate, Approved approved) {
        this.fromCustomer = fromCustomer;
        this.beneficiaryAcNo = beneficiaryAcNo;
        this.beneficiaryAddedDate = beneficiaryAddedDate;
        this.approved = approved;
    }

    public BeneficiaryInformation() {
    }

    public long getFromCustomer() {
        return fromCustomer;
    }

    public void setFromCustomer(long fromCustomer) {
        this.fromCustomer = fromCustomer;
    }

    public long getBeneficiaryAcNo() {
        return beneficiaryAcNo;
    }

    public void setBeneficiaryAcNo(long beneficiaryAcNo) {
        this.beneficiaryAcNo = beneficiaryAcNo;
    }

    public Date getBeneficiaryAddedDate() {
        return beneficiaryAddedDate;
    }

    public void setBeneficiaryAddedDate(Date beneficiaryAddedDate) {
        this.beneficiaryAddedDate = beneficiaryAddedDate;
    }

    public Approved getApproved() {
        return approved;
    }

    public void setApproved(Approved approved) {
        this.approved = approved;
    }
}
