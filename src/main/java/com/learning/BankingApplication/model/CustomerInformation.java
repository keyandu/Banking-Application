package com.learning.BankingApplication.model;


import com.learning.BankingApplication.entity.Status;

public class CustomerInformation {
    private long id;
    private String name;
    private Status status;

    @Override
    public String toString() {
        return "CustomerInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
