package com.learning.BankingApplication.service;


import com.learning.BankingApplication.model.AccountInformation;

import java.util.List;

public interface AccountService {
    public List<AccountInformation> findAllAccountToBeApproved();
    public List<AccountInformation> listAllAccount();
}
