package design_patterns.Creation.FactoryMethod;

public abstract class PaymentProcessor {

    // Creator: initiatePayment() is the shared algorithm, written once.
    // createGateway() is the factory method - each subclass decides which
    // concrete PaymentGateway (product) gets created.

    public void initiatePayment(){
        validate("payment");
        PaymentGateway gateway = createGateway();
        gateway.processTransaction();
        save("Payment");
    }

    // shared steps, written once:
    private void validate(String paymentData) {  }
    private void save(String payment) { }
    private void auditLog(String msg) {  }

    protected abstract PaymentGateway createGateway();
}
