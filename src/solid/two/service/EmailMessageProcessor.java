package solid.two.service;

public class EmailMessageProcessor implements IMessageProcessor {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending confirmation email to: " + recipient);
    }
}