package design_patterns.Creation.abstractFactory;

public interface PaymentProcessorFactory {

    PaymentGateway   createGateway();
    WebhookVerifier  createWebhookVerifier();
    RefundHandler    createRefundHandler();
}
