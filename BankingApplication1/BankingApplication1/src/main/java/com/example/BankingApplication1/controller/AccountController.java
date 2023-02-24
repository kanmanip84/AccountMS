package com.example.BankingApplication1.controller;

import com.example.BankingApplication1.entity.Account;
import com.example.BankingApplication1.repository.AccountRepository;
import com.example.BankingApplication1.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountServices service;
    @Autowired
    private AccountRepository repository;

    @PostMapping("/addAccount")
    public ResponseEntity<?> addAccount(@RequestBody Account account) {

        if (account.getCustomerId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("customer id is required");
        } else
            return ResponseEntity.ok(repository.save(account));
    }

    @PostMapping("/addAccounts")
    public List<Account> addAccounts(@RequestBody List<Account> accounts) {
        return service.saveAccounts(accounts);
    }

    @GetMapping("/accounts")
    public List<Account> findAllAccounts() {
        return service.getAccounts();
    }

    @GetMapping("/accountById/{accountNumber}")
    public Account findById(@PathVariable int accountNumber) {
        return service.getAccountById(accountNumber);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public String deleteAccount(@PathVariable int accountNumber) {
        return service.deleteAccount(accountNumber);
    }

    @DeleteMapping("/deleteByCustomerId/{customerId}")
    public String deleteAccountByCustomerId(@PathVariable int customerId) {
        service.deleteAccountsByCustomerId(customerId);
        return ("Account deleted for customer id  " + customerId);
    }

    @GetMapping("/balance/{accountNumber}")
    public String getBalance(@PathVariable int accountNumber) {
        return service.getBalanceById(accountNumber);
    }

    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account account) {
       return service.updateAccount(account);
    }
}
