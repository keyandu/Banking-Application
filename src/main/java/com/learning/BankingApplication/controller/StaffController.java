package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transaction;
import com.learning.BankingApplication.model.BeneficiaryInformation;
import com.learning.BankingApplication.model.CustomerInformation;
import com.learning.BankingApplication.payload.response.AccountDetailResponse;
import com.learning.BankingApplication.payload.response.TransactionResponse;
import com.learning.BankingApplication.repo.UserRepository;
import com.learning.BankingApplication.request.ApproveAccountRequest;
import com.learning.BankingApplication.request.ApproveBeneficiaryRequest;
import com.learning.BankingApplication.request.ChangeCustomerStatusRequest;

import com.learning.BankingApplication.request.GetCustomerByIdRequest;

import com.learning.BankingApplication.response.ApproveBeneficiaryResponse;
import com.learning.BankingApplication.response.GetCustomerByIdResponse;
import com.learning.BankingApplication.service.AccountService;
import com.learning.BankingApplication.service.BeneficiaryService;
import com.learning.BankingApplication.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/staff/customer")
public class StaffController {
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;
    @Autowired
    BeneficiaryService beneficiaryService;

    @GetMapping("/listAllCustomer")
    public ResponseEntity<List<CustomerInformation>> listAllCustomer() {
        return new ResponseEntity<List<CustomerInformation>>(userService.listAllCustomerByStaff(), HttpStatus.OK);
    }
    //Not Working
    @PutMapping("/changeCustomerStatus")

    public ResponseEntity<?> changeCustomerStatus(@RequestBody ChangeCustomerStatusRequest changeCustomerStatusRequest) {
       // System.out.println(changeCustomerStatusRequest.getCustomerId());

        String result=userService.changeCustomerStatus(changeCustomerStatusRequest);

        if(result.equals("Instruction is null")||result.equals("Customer status not changed")||result.equals("customer not find")){
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Change customer status success", HttpStatus.OK);
    }

    
    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id) {
        GetCustomerByIdResponse result = userService.getCustomerById(id);
        if(result!=null){
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity("Customer Not Found", HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/getAllAccountToBeApproved")

    public ResponseEntity getAllAccountToBeApprove() {

        return new ResponseEntity(accountService.findAllAccountToBeApproved(), HttpStatus.OK);

    }
    
    @GetMapping("/dispalyAllAccount")
    public ResponseEntity dispalyAllAccount() {

        return new ResponseEntity(accountService.listAllAccount(), HttpStatus.OK);

    }
    

    @PutMapping("/approveAccountOrNot")
    public ResponseEntity approveAccountOrNot(@RequestBody @Valid ApproveAccountRequest approveAccountRequest) {
    	String msg = accountService.approveAccount(approveAccountRequest);
        if(msg==null){
        	return new ResponseEntity("Account not found, approved failed", HttpStatus.BAD_REQUEST);
            
        }
        return new ResponseEntity(msg, HttpStatus.OK);
        

    }

    @GetMapping("/getAccountStatmentById/{id}")
    public ResponseEntity getAccountStatmentById(@PathVariable long id){
    	Account acc = accountService.accountDetail(id);
    	if(acc==null) return new ResponseEntity<String>("Account doesn't exist",HttpStatus.BAD_REQUEST);
    	List<Transaction> t = acc.getTransactions();
    	List<TransactionResponse> tr = new ArrayList<TransactionResponse>();
    	for(Transaction tran: t) {
    		tr.add(new TransactionResponse(tran.getCreateDate(), tran.getReference(), tran.getAmount()));
    	}
    	AccountDetailResponse res = new AccountDetailResponse(acc.getAccountNo(), acc.getAccountType(), acc.getAccountBalance(), acc.getAccountStatus(), tr);
        return new ResponseEntity(res,HttpStatus.OK);

    }
    @GetMapping("/listBeneficiaryToBeApproved")
    public ResponseEntity<List<BeneficiaryInformation>> listBeneficiaryToBeApproved(){
        return new ResponseEntity(beneficiaryService.listAllBeneficiaryToBeApproved(),HttpStatus.OK);

    }
    @PutMapping("/approveBeneficiaryOrNot")
    public ResponseEntity approveBeneficiaryOrNot(@RequestBody ApproveBeneficiaryRequest approveBeneficiaryRequest){
        System.out.println(approveBeneficiaryRequest.getApproved());
        ApproveBeneficiaryResponse result= beneficiaryService.approveBeneficiaryOrNot(approveBeneficiaryRequest);
        if(result==null){
            return  new ResponseEntity("Sorry beneficiary not approved",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(result,HttpStatus.OK);

    }
}
