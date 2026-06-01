package ryzhenin.dz11.controller;

import org.springframework.web.bind.annotation.*;
import ryzhenin.dz11.dto.*;
import ryzhenin.dz11.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountDetailController {
    private final AccountService accountService;
    public AccountDetailController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/{accountId}")
    public AccountResponse getAccount(@PathVariable long accountId) {
        return accountService.getAccountById(accountId);
    }
    @PostMapping("/{accountId}/deposit")
    public AccountResponse deposit(@PathVariable long accountId, @RequestBody DepositRequest request) {
        return accountService.deposit(accountId, request);
    }
    @PostMapping("/{accountId}/withdraw")
    public AccountResponse withdraw(@PathVariable long accountId, @RequestBody WithdrawRequest request) {
        return accountService.withdraw(accountId, request);
    }
}