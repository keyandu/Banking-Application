package com.learning.BankingApplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String password;
    private String fullname;
    private Roles roles;
    @OneToMany
    private List<Account> accounts;
    private String address;
    private long mobileNo;
    private String pan;
    private String secretQuestion;
    private String secretAnswer;
    private Date createDate;
    @OneToMany
    private List<Beneficiary> beneficiary;
    private Status customerStatus;
    @OneToMany
    private List<Transfer> transfers;
    public Status getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Status customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getmobileNo() {
        return mobileNo;
    }

    public void setmobileNo(long mobileNo) {
        this.mobileNo= mobileNo;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Beneficiary> getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(List<Beneficiary> beneficiary) {
        this.beneficiary = beneficiary;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", roles=" + roles +
                ", accounts=" + accounts +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                ", pan='" + pan + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", secretAnswer='" + secretAnswer + '\'' +
                ", createDate=" + createDate +
                ", beneficiary=" + beneficiary +
                ", customerStatus=" + customerStatus +
                '}';
    }
}
