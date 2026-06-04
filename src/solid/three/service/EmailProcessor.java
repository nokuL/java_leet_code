package solid.three.service;

public class EmailProcessor implements  IMessageProcessor{

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
