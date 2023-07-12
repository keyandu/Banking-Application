package com.learning.BankingApplication.payload.request;

public class TransferRequest {

    private String fromAccountNo;
    private String toAccountNo;
    private double amount;
    private String reference;


    public TransferRequest() {

    }

    public String getFromAccountNo() {
        return fromAccountNo;
    }

    public void setFromAccountNo(String fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public String getToAccountNo() {
        return toAccountNo;
    }

    public void setToAccountNo(String toAccountNo) {
        this.toAccountNo = toAccountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public TransferRequest(String fromAccountNo, String toAccountNo, double amount, String reference) {
        this.fromAccountNo = fromAccountNo;
        this.toAccountNo = toAccountNo;
        this.amount = amount;
        this.reference = reference;
    }
}