package design_patterns.Creation.FactoryMethod;

public class PaymentService {

    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment() {
        paymentProcessor.initiatePayment();
    }
}
