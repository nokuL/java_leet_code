package design_patterns.Creation.FactoryMethod;

public class EcocashPaymentProcessorFactory extends PaymentProcessor {
    @Override
    protected PaymentGateway createGateway() {
        return new EcocashPaymentGateway();
    }
}