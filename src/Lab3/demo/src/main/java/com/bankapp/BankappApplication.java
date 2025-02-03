package com.bankapp;

import com.bankapp.model.Account;
import com.bankapp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	private AccountRepository accountRepository;

	@Autowired
	public BankappApplication(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("PORT STARTED ON SERVER 3000");
		accountRepository.save(new Account("Sudeev", 3000.0));
		accountRepository.save(new Account("Name2", 20000.0));
	}
}
