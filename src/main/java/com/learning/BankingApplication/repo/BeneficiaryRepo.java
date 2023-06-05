package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.entity.Beneficiary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary,Long> {
}
