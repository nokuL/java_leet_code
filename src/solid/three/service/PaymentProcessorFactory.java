package solid.three.service;

public class PaymentProcessorFactory {

    public IPaymentProcessor getProcessor(String paymentMethod) {
        switch (paymentMethod) {
            case "ECOCASH": return new EcocashProcessor();
            case "IVERI":   return new IveriProcessor();
            default: throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
    }
}