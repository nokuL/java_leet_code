package solid.four;

import solid.four.Account;

public class TransferRequest {
    private Account sourceAccount;
    private Account targetAccount;
    private String targetExternalId;
    private String cryptoAddress;
    private double amount;
    private String currency;
    private String type; // INTERNAL, EXTERNAL, CRYPTO
    public Account getSourceAccount() { return sourceAccount; }
    public Account getTargetAccount() { return targetAccount; }
    public String getTargetExternalId() { return targetExternalId; }
    public String getCryptoAddress() { return cryptoAddress; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getType() { return type; }
    public void setSourceAccount(Account src) { this.sourceAccount = src; }
    public void setTargetAccount(Account tgt) { this.targetAccount = tgt; }
    public void setTargetExternalId(String id) { this.targetExternalId = id; }
    public void setCryptoAddress(String addr) { this.cryptoAddress = addr; }
    public void setAmount(double amt) { this.amount = amt; }
    public void setCurrency(String curr) { this.currency = curr; }
    public void setType(String type) { this.type = type; }
}