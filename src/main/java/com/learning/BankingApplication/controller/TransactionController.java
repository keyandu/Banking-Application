package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transaction;
import com.learning.BankingApplication.entity.Transfer;
import com.learning.BankingApplication.service.TransactionService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account-statement")
    public ResponseEntity<List<Transaction>> viewAccountStatement(@RequestBody String account) {
        List<Transaction> result= transactionService.viewAccountStatement(account);
        if(result==null){
            result=new ArrayList<Transaction>();
        }
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdrawCash(@RequestBody String fromAcc,double Amount,String reference) {
        String result=transactionService.withdrawCash(fromAcc,Amount,reference);
        if(result.equals("success")){
            return new ResponseEntity("withdraw success",HttpStatus.OK);
        }
        return new ResponseEntity(result,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> depositCash(@RequestBody String toAcc,double Amount,String reference) {
        String result= transactionService.depositCash(toAcc,Amount,reference);
        if(result.equals("success")){
            return new ResponseEntity("deposit success",HttpStatus.OK);
        }
        return new ResponseEntity(result,HttpStatus.BAD_REQUEST);
    }

}