package com.learning.BankingApplication.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;
    private AccountType accountType;
    private double accountBalance;
    private String approved;
    @ManyToOne
    private User owner;
    private Date createDate;
    private AccountStatus status;
    @OneToMany
    private List<Transaction> transactions;

    @OneToMany
    private List<Beneficiary> beneficiaries;
}
