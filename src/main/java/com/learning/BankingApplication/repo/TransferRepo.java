package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.model.Transfer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TransferRepo extends JpaRepository<Transfer,Long> {
}
