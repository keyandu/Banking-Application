package com.learning.BankingApplication.serviceImp;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.exception.UserNotFoundException;
import com.learning.BankingApplication.model.AccountInformation;
import com.learning.BankingApplication.payload.request.AccountRequest;
import com.learning.BankingApplication.payload.response.MessageResponse;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.UserRepo;
import com.learning.BankingApplication.request.ApproveAccountRequest;
import com.learning.BankingApplication.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	UserRepo userDAO;
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

    @Override
    public String approveAccount(ApproveAccountRequest approveAccountRequest) {
        String accountNo = approveAccountRequest.getAccNo();
        System.out.println(accountNo);
        Account  account = accountRepo.getAccountByAccountNo(accountNo).orElse(null);
        if(account==null){

            return null;

        }
        
        if(approveAccountRequest.getApproveOrNot().equals("Approve")) {
        	account.setApproved(Approved.YES);
        	accountRepo.save(account);
        	return "Account is being approved";
        }
        if(approveAccountRequest.getApproveOrNot().equals("Disapprove")) {
        	account.setApproved(Approved.NO);
        	accountRepo.save(account);
        	return "Account is not approved";
        }
        return "Something went wrong";
        
        
        
    }
    @Override
	public ResponseEntity<?> create(long userid, AccountRequest c) {
		// TODO Auto-generated method stub
    	
    	User user = userDAO.findById(userid).orElse(null);
    	
		if(user==null) {
			return ResponseEntity.ok(new MessageResponse("User not found"));
		}
		
		Account acct = new Account(c.getAccountType(),c.getAccountBalance(),user,new Date());
		accountRepo.save(acct);
	
		
		List<Account> lisAcct = user.getAccounts();
		if(lisAcct ==null) lisAcct=new ArrayList<Account>();
		
		lisAcct.add(acct);
		
		user.setAccounts(lisAcct);
		
		userDAO.save(user);
		
		return ResponseEntity.ok("created your account");
	}
	@Override
	public List<Account> getAccountsByUser(Long id) {
		// TODO Auto-generated method stub
		User user = userDAO.findById(id).orElse(null);
		if(user==null) return null;
		return user.getAccounts();
	}
	@Override
	public Account accountDetail(long id) {
		return accountRepo.findById(id).orElse(null);
	}

    @Override
    public List<AccountInformation> findAllAccountToBeDisApproved() {
        return null;
    }
}
