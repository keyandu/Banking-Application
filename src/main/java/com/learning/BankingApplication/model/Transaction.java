package com.learning.BankingApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private Date createDate;
    private String reference;
    private double amount;
    private TransactionType transactionType;
    @ManyToOne
    private Account fromAccount;

    @ManyToOne
    private Account toAccount;

    private String approved;
}
