package com.learning.BankingApplication.serviceImp;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.model.AccountInformation;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;
    @Override
    public List<AccountInformation> findAllAccountToBeApproved() {
        List<Account> accounts = accountRepo.findAllByApproved(Approved.NO);
        List<AccountInformation> result= new ArrayList<AccountInformation>();
        for(Account a : accounts){
            result.add(new AccountInformation(a.getAccountType(),a.getOwner().getFullname(),a.getAccountNo(),a.getCreateDate(),a.getApproved()));
        }
        return result;
    }

    @Override
    public List<AccountInformation> listAllAccount() {
        List<Account> accounts = accountRepo.findAll();
        List<AccountInformation> result= new ArrayList<AccountInformation>();
        for(Account a : accounts){
            result.add(new AccountInformation(a.getAccountType(),a.getOwner().getFullname(),a.getAccountNo(),a.getCreateDate(),a.getApproved()));
        }
        return result;
    }
}
