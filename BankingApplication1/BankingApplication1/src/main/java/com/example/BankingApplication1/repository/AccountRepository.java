package com.example.BankingApplication1.repository;

import com.example.BankingApplication1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
     List<Account> findByCustomerId(int customerId);
   }
