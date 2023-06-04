package com.learning.BankingApplication.repo;
import org.springframework.stereotype.Repository;
import com.learning.BankingApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
