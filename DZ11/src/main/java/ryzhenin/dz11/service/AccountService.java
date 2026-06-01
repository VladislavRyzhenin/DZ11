package ryzhenin.dz11.service;

import org.springframework.stereotype.Service;
import ryzhenin.dz11.dto.*;
import ryzhenin.dz11.entity.AccountEntity;
import ryzhenin.dz11.enums.AccountType;
import ryzhenin.dz11.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(long userId, CreateAccountRequest request) {
        AccountEntity account = new AccountEntity(0, userId, request.getType());
        AccountEntity saved = accountRepository.save(account);
        return mapToResponse(saved);
    }

    public List<AccountResponse> getAccountsByUserId(long userId) {
        List<AccountResponse> responses = new ArrayList<>();
        for (AccountEntity acc : accountRepository.findByUserId(userId)) {
            responses.add(mapToResponse(acc));
        }
        return responses;
    }

    public AccountResponse getAccountById(long accountId) {
        AccountEntity account = accountRepository.findById(accountId).orElseThrow();
        return mapToResponse(account);
    }

    public AccountResponse deposit(long accountId, DepositRequest request) {
        AccountEntity account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + request.getAmount());
        account.setAvailableBalance(account.getAvailableBalance() + request.getAmount());
        return mapToResponse(account);
    }

    public AccountResponse withdraw(long accountId, WithdrawRequest request) {
        AccountEntity account = accountRepository.findById(accountId).orElseThrow();
        if (account.getType() == AccountType.DEBIT && account.getBalance() < request.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }
        if (account.getType() == AccountType.CREDIT && account.getAvailableBalance() < request.getAmount()) {
            throw new RuntimeException("Credit limit exceeded");
        }
        account.setBalance(account.getBalance() - request.getAmount());
        account.setAvailableBalance(account.getAvailableBalance() - request.getAmount());
        return mapToResponse(account);
    }

    public AccountSummaryResponse getSummary(long userId) {
        List<AccountEntity> accounts = accountRepository.findByUserId(userId);
        double totalBalance = 0;
        double totalAvailable = 0;
        for (AccountEntity acc : accounts) {
            totalBalance += acc.getBalance();
            totalAvailable += acc.getAvailableBalance();
        }
        return new AccountSummaryResponse(userId, totalBalance, totalAvailable, accounts.size());
    }

    private AccountResponse mapToResponse(AccountEntity acc) {
        Double credit = acc.getType() == AccountType.CREDIT ? acc.getCreditLine() : null;
        return new AccountResponse(acc.getId(), acc.getType(), acc.getBalance(), acc.getAvailableBalance(), credit);
    }
}