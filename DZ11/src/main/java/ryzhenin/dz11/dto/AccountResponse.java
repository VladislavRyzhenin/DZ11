package ryzhenin.dz11.dto;

import ryzhenin.dz11.enums.AccountType;

public class AccountResponse {
    private long id;
    private AccountType type;
    private double balance;
    private double availableBalance;
    private Double creditLine;

    public AccountResponse(long id, AccountType type, double balance, double availableBalance, Double creditLine) {
        this.id = id; this.type = type; this.balance = balance; this.availableBalance = availableBalance; this.creditLine = creditLine;
    }

    public long getId() { return id; }
    public AccountType getType() { return type; }
    public double getBalance() { return balance; }
    public double getAvailableBalance() { return availableBalance; }
    public Double getCreditLine() { return creditLine; }
}