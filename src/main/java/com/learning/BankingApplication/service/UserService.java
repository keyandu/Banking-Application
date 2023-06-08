package com.learning.BankingApplication.service;

import com.learning.BankingApplication.entity.User;

import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.request.ChangeCustomerStatusRequest;
import com.learning.BankingApplication.request.GetCustomerByIdRequest;
import com.learning.BankingApplication.response.GetCustomerByIdResponse;

import java.util.List;


public interface UserService {
   public List<CustomerInformation> listAllCustomerByStaff();

   public String changeCustomerStatus(ChangeCustomerStatusRequest changeCustomerStatusRequest);

   public GetCustomerByIdResponse getCustomerById(GetCustomerByIdRequest getCustomerByIdRequest);
}
