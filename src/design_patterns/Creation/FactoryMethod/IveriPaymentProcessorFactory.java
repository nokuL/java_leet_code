package design_patterns.Creation.FactoryMethod;

public class IveriPaymentProcessorFactory extends PaymentProcessor {
    @Override
    protected PaymentGateway createGateway() {
        return new IveriPaymentGateway();
    }
}