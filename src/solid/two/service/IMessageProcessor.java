package solid.two.service;

public interface IMessageProcessor {

    void send(String recipient, String message);
}