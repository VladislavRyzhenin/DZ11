package ryzhenin.dz11.dto;

public class AccountSummaryResponse {
    private long userId;
    private double totalBalance;
    private double totalAvailableBalance;
    private int accountsCount;
    public AccountSummaryResponse(long userId, double totalBalance, double totalAvailableBalance, int accountsCount) {
        this.userId = userId; this.totalBalance = totalBalance; this.totalAvailableBalance = totalAvailableBalance; this.accountsCount = accountsCount;
    }
    public long getUserId() { return userId; }
    public double getTotalBalance() { return totalBalance; }
    public double getTotalAvailableBalance() { return totalAvailableBalance; }
    public int getAccountsCount() { return accountsCount; }
}