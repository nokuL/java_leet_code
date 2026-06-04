package solid.one;

public class IveriProcesssor implements PaymentProcessor{

    @Override
    public void processPayment(PaymentRequest paymentRequest) {
        if (!(paymentRequest instanceof CardPaymentRequest)) {
            throw new IllegalArgumentException("IveriProcessor requires a CardPaymentRequest");
        }
        CardPaymentRequest request = (CardPaymentRequest) paymentRequest;
        System.out.println("Charging card: " + request.getCardNumber());
    }

}
