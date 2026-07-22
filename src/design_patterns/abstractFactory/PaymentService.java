package design_patterns.abstractFactory;

public class PaymentService {

    // Client depends only on the abstract factory + abstract products -
    // it never references EcoCash*/Iveri* classes directly.
    private final PaymentGateway gateway;
    private final WebhookVerifier webhookVerifier;
    private final RefundHandler refundHandler;

    public PaymentService(PaymentProcessorFactory factory) {
        this.gateway = factory.createGateway();
        this.webhookVerifier = factory.createWebhookVerifier();
        this.refundHandler = factory.createRefundHandler();
    }

    public void pay() {
        gateway.processTransaction();
    }

    public void handleWebhook(String payload, String signature) {
        if (webhookVerifier.verify(payload, signature)) {
            // proceed to reconcile the payment
        }
    }

    public void refund(String transactionId) {
        refundHandler.processRefund(transactionId);
    }

    public static void main(String[] args) {
        // Swap the whole family by swapping one factory - that's the point
        // of Abstract Factory: gateway/verifier/refundHandler are always
        // guaranteed to belong to the same provider.
        PaymentService ecocashService = new PaymentService(new EcoCashProviderFactory());
        ecocashService.pay();
        ecocashService.refund("txn-123");

        PaymentService iveriService = new PaymentService(new IverProviderFactory());
        iveriService.pay();
        iveriService.refund("txn-456");
    }
}