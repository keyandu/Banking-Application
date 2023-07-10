package com.learning.BankingApplication.service;

import com.learning.BankingApplication.entity.PasswordResetToken;
import com.learning.BankingApplication.entity.User;

import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.payload.request.UpdateCustomerReq;
import com.learning.BankingApplication.request.ChangeCustomerStatusRequest;
import com.learning.BankingApplication.request.ChangeStaffStatusRequest;
import com.learning.BankingApplication.request.GetCustomerByIdRequest;
import com.learning.BankingApplication.response.GetCustomerByIdResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;


public interface UserService {
   public List<CustomerInformation> listAllCustomerByStaff();

   public String changeCustomerStatus(ChangeCustomerStatusRequest changeCustomerStatusRequest);

   public GetCustomerByIdResponse getCustomerById(Long id);

   public ResponseEntity<?> getUserProfile(Long id);
   public void createPasswordResetTokenForUser(User user, String token);

   public User getUserByPasswordResetToken(PasswordResetToken passToken);

   public void changeUserPassword(User user, String newPassword);

   public ResponseEntity<?> updateById(Long id, UpdateCustomerReq updateCustomer);


   public boolean existsByUsername(String username);

   public void save(User user);
   public List<CustomerInformation> listAllStaffByAdmin();

   public String enableOrDisableStaff(ChangeStaffStatusRequest changeStaffStatusRequest);

}
