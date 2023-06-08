package com.learning.BankingApplication.request;

import com.learning.BankingApplication.entity.Approved;

import java.util.Date;

public class ApproveAccountRequest {
    private String accType;
    private String customerName;
    private Long accNo;
    private Date dateCreated;
    private Approved approved;
    private String staffUserName;

    public ApproveAccountRequest(String accType, String customerName, Long accNo, Date dateCreated, Approved approved, String staffUserName) {
        this.accType = accType;
        this.customerName = customerName;
        this.accNo = accNo;
        this.dateCreated = dateCreated;
        this.approved = approved;
        this.staffUserName = staffUserName;
    }
    public ApproveAccountRequest() {

    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
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

    public String getStaffUserName() {
        return staffUserName;
    }

    public void setStaffUserName(String staffUserName) {
        this.staffUserName = staffUserName;
    }
}
