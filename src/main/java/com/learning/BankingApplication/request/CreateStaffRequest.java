package com.learning.BankingApplication.request;

public class CreateStaffRequest {
    private String staffFullName;
    private String staffUserName;
    private String staffPassword;

    public CreateStaffRequest(String staffFullName, String staffUserName, String staffPassword) {
        this.staffFullName = staffFullName;
        this.staffUserName = staffUserName;
        this.staffPassword = staffPassword;
    }
    public CreateStaffRequest() {

    }

    public String getStaffFullName() {
        return staffFullName;
    }

    public void setStaffFullName(String staffFullName) {
        this.staffFullName = staffFullName;
    }

    public String getStaffUserName() {
        return staffUserName;
    }

    public void setStaffUserName(String staffUserName) {
        this.staffUserName = staffUserName;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
}
