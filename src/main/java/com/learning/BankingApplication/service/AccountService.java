package com.learning.BankingApplication.service;


import com.learning.BankingApplication.model.AccountInformation;
import com.learning.BankingApplication.request.ApproveAccountRequest;

import java.util.List;

public interface AccountService {
    public List<AccountInformation> findAllAccountToBeApproved();
    public List<AccountInformation> listAllAccount();
    public boolean approveAccount(ApproveAccountRequest approveAccountRequest);
}
