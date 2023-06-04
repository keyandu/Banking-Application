package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.entity.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
}
