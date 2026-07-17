package solid.one;

public class CardPaymentRequest extends PaymentRequest {
    private String cardNumber;

    public CardPaymentRequest(String orderId, double amount, String cardNumber) {
        super(orderId, amount);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() { return cardNumber; }
}