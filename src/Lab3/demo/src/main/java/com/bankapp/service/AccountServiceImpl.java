package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.exceptions.InsufficientFundsException;
import com.bankapp.model.Account;
import com.bankapp.repo.AccountRepository;
import com.bankapp.service.aspect.Loggable;
import com.bankapp.util.ConverterUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Loggable
    @Override
    public void transfer(int from, int to, Double amount) {
        // Withdraw money
        Account fromAccount = ConverterUtil.convertToAccount(getAccount(from));
        Double newBalance = fromAccount.getBalance() - amount;
        if (newBalance < 0) {
            throw new InsufficientFundsException("Not enough money in account to withdraw");
        }
        fromAccount.setBalance(newBalance);
        accountRepository.save(fromAccount);

        // Deposit Money
        deposit(to, amount);
    }

    @Loggable
    @Override
    public void deposit(int id, Double amount) {
        Account toAccount = ConverterUtil.convertToAccount(getAccount(id));
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountRepository.save(toAccount);
    }

    @Override
    public AccountDto getAccount(int id) {
        return accountRepository.findById(id)
                .map(ConverterUtil::convertToAccountDto)
                .orElseThrow(() -> new AccountNotFoundException("Account " + id + " not found"));
    }
}
