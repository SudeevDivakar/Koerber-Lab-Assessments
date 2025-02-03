package com.bankapp.service;

import com.bankapp.dto.AccountDto;

public interface AccountService {
    public void transfer(int from, int to, Double amount);
    public void deposit(int id, Double amount);
    public AccountDto getAccount(int id);
}
