package solid.three.service;

public class PaymentService implements IPaymentService{

    private final IPaymentProcessor paymentProcessor;

    public PaymentService(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public void processpayment(String id) {
        paymentProcessor.processPayment(id);

    }
}
