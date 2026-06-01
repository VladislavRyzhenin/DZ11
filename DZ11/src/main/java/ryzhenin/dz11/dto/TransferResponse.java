package ryzhenin.dz11.dto;

public class TransferResponse {
    private long fromAccountId;
    private long toAccountId;
    private double amount;
    private String status;
    public TransferResponse(long fromAccountId, long toAccountId, double amount, String status) {
        this.fromAccountId = fromAccountId; this.toAccountId = toAccountId; this.amount = amount; this.status = status;
    }
    public long getFromAccountId() { return fromAccountId; }
    public long getToAccountId() { return toAccountId; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}