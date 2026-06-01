package ryzhenin.dz11.repository;

import org.springframework.stereotype.Repository;
import ryzhenin.dz11.entity.AccountEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {
    private final List<AccountEntity> accounts = new ArrayList<>();
    private long nextId = 1;

    public AccountEntity save(AccountEntity account) {
        account.setId(nextId++);
        accounts.add(account);
        return account;
    }

    public Optional<AccountEntity> findById(long id) {
        return accounts.stream().filter(a -> a.getId() == id).findFirst();
    }

    public List<AccountEntity> findByUserId(long userId) {
        return accounts.stream().filter(a -> a.getUserId() == userId).toList();
    }
}