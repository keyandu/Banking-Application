package com.learning.BankingApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue
    private long beneficiaryAccountNo;
    private String beneficiaryName;
    private BeneficiaryActive active;
    @ManyToOne
    private User customer;

    private String accountNo;
    private Date beneficiaryAddDate;
    private String Approved="No";

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public BeneficiaryActive getActive() {
        return active;
    }

    public void setActive(BeneficiaryActive active) {
        this.active = active;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer1) {
        this.customer = customer1;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getBeneficiaryAddDate() {
        return beneficiaryAddDate;
    }

    public void setBeneficiaryAddDate(Date beneficiaryAddDate) {
        this.beneficiaryAddDate = beneficiaryAddDate;
    }

    public String getApproved() {
        return Approved;
    }

    public void setApproved(String approved) {
        Approved = approved;
    }

    public long getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "beneficiaryAccountNo=" + beneficiaryAccountNo +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", active=" + active +
                ", customer=" + customer +
                ", accountNo='" + accountNo + '\'' +
                ", beneficiaryAddDate=" + beneficiaryAddDate +
                ", Approved='" + Approved + '\'' +
                '}';
    }
}
