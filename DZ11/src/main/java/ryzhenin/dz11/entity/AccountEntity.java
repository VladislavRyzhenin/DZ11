package ryzhenin.dz11.entity;

import ryzhenin.dz11.enums.AccountType;

public class AccountEntity {
    private long id;
    private long userId;
    private AccountType type;
    private double balance;
    private double availableBalance;
    private double creditLine;

    public AccountEntity() {}

    public AccountEntity(long id, long userId, AccountType type) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.balance = 0;
        this.creditLine = type == AccountType.CREDIT ? 20000 : 0;
        this.availableBalance = this.creditLine;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getUserId() { return userId; }
    public void setUserId(long userId) { this.userId = userId; }
    public AccountType getType() { return type; }
    public void setType(AccountType type) { this.type = type; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public double getAvailableBalance() { return availableBalance; }
    public void setAvailableBalance(double availableBalance) { this.availableBalance = availableBalance; }
    public double getCreditLine() { return creditLine; }
    public void setCreditLine(double creditLine) { this.creditLine = creditLine; }
}