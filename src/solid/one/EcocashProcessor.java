package solid.one;

public class EcocashProcessor implements PaymentProcessor {

    @Override
    public void processPayment(PaymentRequest paymentRequest) {
        if (!(paymentRequest instanceof EcocashPaymentRequest)) {
            throw new IllegalArgumentException("EcocashProcessor requires an EcocashPaymentRequest");
        }
        EcocashPaymentRequest request = (EcocashPaymentRequest) paymentRequest;
        System.out.println("Sending EcoCash to: " + request.getPhone());
    }
}
