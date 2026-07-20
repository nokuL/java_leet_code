package design_patterns.Creation.abstractFactory;

public abstract class WebhookVerifier {

    public abstract boolean verify(String payload, String signature);
}
