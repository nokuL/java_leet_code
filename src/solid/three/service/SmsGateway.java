package solid.three.service;

public class SmsGateway implements IMessageProcessor{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
