package com.learning.BankingApplication.entity;



import java.util.ArrayList;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "fullname") 
    })
//uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "email" })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  private String fullname;
  // do not chack repeatcation

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  
  private Set<Role> roles = new HashSet<>();

    @OneToMany
    private List<Account> accounts;

    private String address;
    private long mobileNo;

    private String secretQuestion;
    private String secretAnswer;

    private Date createDate;
    @OneToMany
    private List<Beneficiary> beneficiary;
    private Status customerStatus;
    @OneToMany
    private List<Transfer> transfers;
  
  public User() {
  }

  public User(String username, String fullname, String password) {
    this.username = username;
    this.fullname = fullname;
    this.password = password;
    this.accounts = new ArrayList<Account>();
    this.createDate = new Date();
    this.beneficiary = new ArrayList<Beneficiary>();
    this.customerStatus=Status.Disable;
    this.transfers=new ArrayList<Transfer>();
  }

  public Long getId() {
    return id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
  
    public Status getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Status customerStatus) {
        this.customerStatus = customerStatus;
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
}
