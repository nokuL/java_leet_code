package solid.four;

public class Account {
    private String id;
    private String ownerEmail;
    private double balance;
    private String type; // SAVINGS, BUSINESS, PREMIUM
    public String getId() { return id; }
    public String getOwnerEmail() { return ownerEmail; }
    public double getBalance() { return balance; }
    public String getType() { return type; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setId(String id) { this.id = id; }
    public void setOwnerEmail(String email) { this.ownerEmail = email; }
    public void setType(String type) { this.type = type; }
}