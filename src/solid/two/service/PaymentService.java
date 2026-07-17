package solid.two.service;

public class PaymentService implements IPaymentService {

    private final PaymentProcessorFactory factory;

    public PaymentService(PaymentProcessorFactory factory) {
        this.factory = factory;
    }

    @Override
    public void processPayment(String paymentMethod, String ownerPhone, String paymentRef, double fee) {
        IPaymentProcessor processor = factory.getProcessor(paymentMethod);
        processor.processPayment(ownerPhone, paymentRef, fee);
    }
}