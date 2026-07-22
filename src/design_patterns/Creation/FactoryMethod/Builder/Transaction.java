package design_patterns.Creation.FactoryMethod.Builder;

public class Transaction {
    private final String transId;
    private final double amount;
    private String description;

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    private String transName;

    public String getTransId() {
        return transId;
    }

    public double getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId='" + transId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public Transaction(Builder builder) {
        this.transId = builder.transId;
        this.amount = builder.amount;
    }

    public static class Builder{

        private final String transId;
        private final double amount;
        private String description;
        private String transName;

        public Builder(String transId, double amount) {
            this.transId = transId;
            this.amount = amount;
        }

        public Builder description(String id){
            this.description = id;
            return this;
        }

        public Builder transName(String name){
            this.transName = name;
            return  this;
        }

        public Transaction build(){
            return new Transaction(this);
        }
    }
}
