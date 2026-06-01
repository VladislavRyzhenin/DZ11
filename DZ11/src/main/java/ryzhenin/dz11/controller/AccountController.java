package ryzhenin.dz11.controller;

import org.springframework.web.bind.annotation.*;
import ryzhenin.dz11.dto.*;
import ryzhenin.dz11.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/accounts")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public AccountResponse createAccount(@PathVariable long userId, @RequestBody CreateAccountRequest request) {
        return accountService.createAccount(userId, request);
    }
    @GetMapping
    public List<AccountResponse> getAccounts(@PathVariable long userId) {
        return accountService.getAccountsByUserId(userId);
    }
    @GetMapping("/summary")
    public AccountSummaryResponse getSummary(@PathVariable long userId) {
        return accountService.getSummary(userId);
    }
}