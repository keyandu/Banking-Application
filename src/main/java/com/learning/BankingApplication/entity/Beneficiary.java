package com.learning.BankingApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue
    private long beneficiaryAccountNo;
    
  
    private String beneficiaryName;
    public Beneficiary(String beneficiaryName, User customer,
			String accountNo, Date beneficiaryAddDate) {
		this.beneficiaryName = beneficiaryName;
		this.active = BeneficiaryActive.YES;
		this.customer = customer;
		this.accountNo = accountNo;
		this.beneficiaryAddDate = beneficiaryAddDate;
		this.approved = Approved.NO;
	}

	private BeneficiaryActive active;
    @ManyToOne
    private User customer;

    public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	private String accountNo;
    private Date beneficiaryAddDate;
    private Approved approved;

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

    public Approved getApproved() {
        return approved;
    }

    public void setApproved(Approved approved) {
        this.approved = approved;
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
                ", Approved='" + approved + '\'' +
                '}';
    }
}
