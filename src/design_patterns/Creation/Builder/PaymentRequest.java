package design_patterns.Creation.Builder;

public class PaymentRequest {

    // required
    private final String merchantId;
    private final double amount;

    // optional
    private final String currency;
    private final String description;
    private final String customerEmail;
    private final String callbackUrl;

    private PaymentRequest(Builder builder) {
        this.merchantId = builder.merchantId;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.description = builder.description;
        this.customerEmail = builder.customerEmail;
        this.callbackUrl = builder.callbackUrl;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "merchantId='" + merchantId + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", description='" + description + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }

    public static class Builder {
        // required
        private final String merchantId;
        private final double amount;

        // optional - sensible defaults
        private String currency = "USD";
        private String description = "";
        private String customerEmail;
        private String callbackUrl;

        public Builder(String merchantId, double amount) {
            this.merchantId = merchantId;
            this.amount = amount;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder callbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
            return this;
        }

        public PaymentRequest build() {
            if (merchantId == null  ) {
                throw new IllegalStateException("merchantId is required");
            }
            if (amount <= 0) {
                throw new IllegalStateException("amount must be positive");
            }
            return new PaymentRequest(this);
        }
    }
}