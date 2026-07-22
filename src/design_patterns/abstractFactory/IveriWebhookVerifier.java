package design_patterns.abstractFactory;

public class IveriWebhookVerifier extends WebhookVerifier {
    @Override
    public boolean verify(String payload, String signature) {
        return false;
    }
}
