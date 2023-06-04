package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.entity.Beneficiary;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary,Long> {
}
