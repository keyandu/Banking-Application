package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Approved;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {

    List<Account> findAllByApproved(Approved approved);
    List<Account> findAll();
}
