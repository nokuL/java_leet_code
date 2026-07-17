package solid.two.service;

public class SmsMessageProcessor implements IMessageProcessor {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to: " + recipient);
    }
}