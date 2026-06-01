package ryzhenin.dz11.service;

import org.springframework.stereotype.Service;
import ryzhenin.dz11.dto.TransferRequest;
import ryzhenin.dz11.dto.TransferResponse;
import ryzhenin.dz11.entity.AccountEntity;
import ryzhenin.dz11.enums.AccountType;
import ryzhenin.dz11.repository.AccountRepository;

@Service
public class TransferService {
    private final AccountRepository accountRepository;
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public TransferResponse transfer(TransferRequest request) {
        AccountEntity from = accountRepository.findById(request.getFromAccountId()).orElseThrow();
        AccountEntity to = accountRepository.findById(request.getToAccountId()).orElseThrow();

        if (from.getType() == AccountType.DEBIT && from.getBalance() < request.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }
        if (from.getType() == AccountType.CREDIT && from.getAvailableBalance() < request.getAmount()) {
            throw new RuntimeException("Credit limit exceeded");
        }

        from.setBalance(from.getBalance() - request.getAmount());
        from.setAvailableBalance(from.getAvailableBalance() - request.getAmount());
        to.setBalance(to.getBalance() + request.getAmount());
        to.setAvailableBalance(to.getAvailableBalance() + request.getAmount());

        return new TransferResponse(from.getId(), to.getId(), request.getAmount(), "SUCCESS");
    }
}