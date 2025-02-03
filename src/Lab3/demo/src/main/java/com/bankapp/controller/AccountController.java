package com.bankapp.controller;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.TransferDTO;
import com.bankapp.dto.TransferredDto;
import com.bankapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<AccountDto> getAccountById (@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(accountService.getAccount(id));
    }

    @PostMapping(path = "transfer")
    public ResponseEntity<TransferredDto> transferMoney(@Valid @RequestBody TransferDTO transferDTO) {
        accountService.transfer(transferDTO.getFrom(), transferDTO.getTo(), transferDTO.getAmount());
        TransferredDto transferredBody =
                TransferredDto.builder()
                        .transferred(true)
                        .amount(transferDTO.getAmount()).build();
        return ResponseEntity.status(HttpStatus.OK).body(transferredBody);
    }
}
