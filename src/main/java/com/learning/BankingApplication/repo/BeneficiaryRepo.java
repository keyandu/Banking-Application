package com.learning.BankingApplication.repo;

import com.learning.BankingApplication.entity.Approved;
import com.learning.BankingApplication.entity.Beneficiary;
import com.learning.BankingApplication.payload.request.BeneficiaryRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary,Long> {
    List<Beneficiary> findBeneficiariesByApproved(Approved approved);
    Beneficiary getBeneficiaryByBeneficiaryAccountNo(String accountNo);

}
