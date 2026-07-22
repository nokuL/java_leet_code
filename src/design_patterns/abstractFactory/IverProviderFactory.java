package design_patterns.abstractFactory;

public class IverProviderFactory implements PaymentProcessorFactory{
    @Override
    public PaymentGateway createGateway() {
        return new IveriGateway();
    }

    @Override
    public WebhookVerifier createWebhookVerifier() {
        return new IveriWebhookVerifier();
    }

    @Override
    public RefundHandler createRefundHandler() {
        return new IveriRefundHandler();
    }
}
