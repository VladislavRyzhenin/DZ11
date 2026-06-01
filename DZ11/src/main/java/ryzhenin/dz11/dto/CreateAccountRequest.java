package ryzhenin.dz11.dto;

import ryzhenin.dz11.enums.AccountType;

public class CreateAccountRequest {
    private AccountType type;
    public AccountType getType() { return type; }
    public void setType(AccountType type) { this.type = type; }
}