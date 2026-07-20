package design_patterns.Creation.abstractFactory;

public class EcoCashProviderFactory implements PaymentProcessorFactory{
    @Override
    public PaymentGateway createGateway() {
        return new EcoCashGateway();
    }

    @Override
    public WebhookVerifier createWebhookVerifier() {
        return new EcoCashHmacVerifier();
    }

    @Override
    public RefundHandler createRefundHandler() {
        return new  EcoCashRefundHandler();
    }
}
