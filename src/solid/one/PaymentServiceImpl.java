package solid.one;

public class PaymentServiceImpl implements IPaymentService {

    private final PaymentProcessor processor;

    public PaymentServiceImpl(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void processPayment(PaymentRequest paymentRequest) {
        processor.processPayment(paymentRequest);
    }
}
