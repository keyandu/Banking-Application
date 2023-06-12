package com.learning.BankingApplication.serviceImp;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.entity.User;
import com.learning.BankingApplication.model.AccountInformation;
import com.learning.BankingApplication.payload.request.AccountRequest;
import com.learning.BankingApplication.repo.AccountRepo;
import com.learning.BankingApplication.repo.UserRepo;
import com.learning.BankingApplication.request.ApproveAccountRequest;
import com.learning.BankingApplication.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean approveAccount(ApproveAccountRequest approveAccountRequest) {
        Long accountNo = approveAccountRequest.getAccNo();
        Account  account = accountRepo.getById(accountNo);
        if(account==null){
            return false;
        }
        if(!account.getAccountType().equals(approveAccountRequest.getAccType())||
                !account.getOwner().getFullname().equals(approveAccountRequest.getCustomerName())
        ){
                //not finish
        }
        return false;
    }
    @Override
	public String create(long userid, AccountRequest c) {
		// TODO Auto-generated method stub
		User user = userDAO.findById(userid).orElse(null);
		System.out.println("find user");
		
		Account acct = new Account(c.getAccountType(),c.getAccountBalance(),user,new Date());
		accountRepo.save(acct);
		System.out.println("account created");
		
		List<Account> lisAcct = user.getAccounts();
		if(lisAcct ==null) lisAcct=new ArrayList<Account>();
		System.out.println("account gets");
		lisAcct.add(acct);
		
		user.setAccounts(lisAcct);
		System.out.println("account sets");
		userDAO.save(user);
		System.out.println("user saved");
		return "created your account";
	}
	@Override
	public List<Account> getAccountsByUser(Long id) {
		// TODO Auto-generated method stub
		User user = userDAO.findById(id).orElse(null);
		return user.getAccounts();
	}
	@Override
	public Account accountDetail(long id) {
		return accountRepo.findById(id).orElse(null);
	}
}
