package solid.two.service;

import java.util.HashMap;
import java.util.Map;

public class PaymentProcessorFactory {

    private final Map<String, IPaymentProcessor> processors = new HashMap<>();

    public PaymentProcessorFactory(IPaymentProcessor ecocashProcessor,
                                   IPaymentProcessor iveriProcessor,
                                   IPaymentProcessor cashProcessor) {
        processors.put("ECOCASH", ecocashProcessor);
        processors.put("IVERI",   iveriProcessor);
        processors.put("CASH",    cashProcessor);
    }

    public IPaymentProcessor getProcessor(String paymentMethod) {
        IPaymentProcessor processor = processors.get(paymentMethod);
        if (processor == null) {
            throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
        return processor;
    }
}