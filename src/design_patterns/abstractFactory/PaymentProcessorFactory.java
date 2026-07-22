package design_patterns.abstractFactory;

public interface PaymentProcessorFactory {

    PaymentGateway   createGateway();
    WebhookVerifier  createWebhookVerifier();
    RefundHandler    createRefundHandler();
}
