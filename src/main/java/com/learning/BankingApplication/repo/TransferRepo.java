package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.entity.Transfer;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TransferRepo extends JpaRepository<Transfer,Long> {
	
	List<Transfer> findByFromAccountNo(String fromAccountNo);
}
