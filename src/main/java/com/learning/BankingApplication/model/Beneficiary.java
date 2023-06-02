package com.learning.BankingApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficiary {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private BeneficiaryActive active;

}
