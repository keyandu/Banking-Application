package com.learning.BankingApplication.controller;

import java.util.List;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Transfer;
import com.learning.BankingApplication.payload.request.TransferRequest;
import com.learning.BankingApplication.response.RegularStringResponse;
import com.learning.BankingApplication.service.AccountService;
import com.learning.BankingApplication.service.TransferService;

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
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/{transferId}")
    public ResponseEntity<Transfer> findTransferById(@PathVariable long transferId) {
        Transfer result=transferService.findTransferBYId(transferId);
        if(result==null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/listAllTransfers")
    public  ResponseEntity<List<Transfer>> listAllTransfers() {
        List<Transfer> result= transferService.listAllTransfers();
        if(result==null){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/make")
    public ResponseEntity<RegularStringResponse> makeTransfer(@RequestBody TransferRequest transferRequest) {

        RegularStringResponse result =new RegularStringResponse( transferService.makeTransfer(transferRequest));
        if(result.getResponse().equals("success")){
            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }
}