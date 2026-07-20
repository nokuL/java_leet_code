package design_patterns.Creation.SimpleFactory;

public class PaymentService {

    private final  SimpleFactoryMethod simpleFactoryMethod;

    private final PaymentProcessor paymentProcessor;


    public PaymentService(SimpleFactoryMethod simpleFactoryMethod, PaymentProcessor paymentProcessor) {
        this.simpleFactoryMethod = simpleFactoryMethod;
        this.paymentProcessor = paymentProcessor;
    }

    public void processpayment(String paymentMethod){
        PaymentProcessor paymentProcessor1 = simpleFactoryMethod.getProcessor(paymentMethod);
        paymentProcessor1.processTranscation();
    }
}
