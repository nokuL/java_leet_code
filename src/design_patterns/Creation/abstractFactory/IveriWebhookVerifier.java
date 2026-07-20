package design_patterns.Creation.abstractFactory;

public class IveriWebhookVerifier extends WebhookVerifier {
    @Override
    public boolean verify(String payload, String signature) {
        return false;
    }
}
