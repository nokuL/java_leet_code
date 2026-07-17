package solid.one;

public class EcocashPaymentRequest extends PaymentRequest {
    private String phone;

    public EcocashPaymentRequest(String orderId, double amount, String phone) {
        super(orderId, amount);
        this.phone = phone;
    }

    public String getPhone() { return phone; }
}