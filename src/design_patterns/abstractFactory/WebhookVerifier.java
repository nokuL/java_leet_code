package design_patterns.abstractFactory;

public abstract class WebhookVerifier {

    public abstract boolean verify(String payload, String signature);
}
