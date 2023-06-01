package com.learning.BankingApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class user {
    @Id
    @GeneratedValue
    private int id;

}
