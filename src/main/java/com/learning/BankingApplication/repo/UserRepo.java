package com.learning.BankingApplication.repo;
import com.learning.BankingApplication.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
