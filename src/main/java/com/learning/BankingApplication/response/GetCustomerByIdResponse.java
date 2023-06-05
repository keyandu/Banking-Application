package com.learning.BankingApplication.response;

import com.learning.BankingApplication.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerByIdResponse {
    private long customerId;
    private String customerName;
    private Status status;
    private Date createDate;

}
