package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.repo.UserRepository;
import com.learning.BankingApplication.request.ApproveAccountRequest;
import com.learning.BankingApplication.request.ChangeCustomerStatusRequest;
import com.learning.BankingApplication.request.GetCustomerByIdRequest;
import com.learning.BankingApplication.response.GetCustomerByIdResponse;
import com.learning.BankingApplication.service.AccountService;
import com.learning.BankingApplication.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/staff/customer")
public class StaffController {
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @GetMapping("/listAllCustomer")
    public ResponseEntity<List<CustomerInformation>> listAllCustomer() {
        return new ResponseEntity(userService.listAllCustomerByStaff(), HttpStatus.OK);
    }
    @PutMapping("/changeCustomerStatus")
    public ResponseEntity changeCustomerStatus(@RequestBody ChangeCustomerStatusRequest changeCustomerStatusRequest) {
       // System.out.println(changeCustomerStatusRequest.getCustomerId());
        String result=userService.changeCustomerStatus(changeCustomerStatusRequest);

        if(result.equals("Customer status not changed")||result.equals("customer not find")){
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("enable Customer success", HttpStatus.OK);
    }


    @GetMapping("/getCustomerById")
    public ResponseEntity getCustomerById(@RequestBody @Valid GetCustomerByIdRequest getCustomerByIdRequest) {
        GetCustomerByIdResponse result = userService.getCustomerById(getCustomerByIdRequest);
        if(result!=null){
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity("Customer Not Found", HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/getAllAccountToBeApproved")
    public ResponseEntity getAllAccountToBeApprove(@RequestBody GetCustomerByIdRequest getCustomerByIdRequest) {

        return new ResponseEntity(accountService.findAllAccountToBeApproved(), HttpStatus.OK);

    }

    @GetMapping("/dispalyAllAccount")
    public ResponseEntity dispalyAllAccount(@RequestBody @Valid GetCustomerByIdRequest getCustomerByIdRequest) {

        return new ResponseEntity(accountService.listAllAccount(), HttpStatus.OK);

    }

    @PutMapping("/approveAccountOrNot")
    public ResponseEntity approveAccountOrNot(@RequestBody @Valid ApproveAccountRequest approveAccountRequest) {

        return new ResponseEntity(accountService.listAllAccount(), HttpStatus.OK);

    }

}
