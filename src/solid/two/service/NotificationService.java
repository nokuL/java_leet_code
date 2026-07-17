package solid.two.service;

public class NotificationService implements INotificationService {

    private final IMessageProcessor emailProcessor;
    private final IMessageProcessor smsProcessor;

    public NotificationService(IMessageProcessor emailProcessor, IMessageProcessor smsProcessor) {
        this.emailProcessor = emailProcessor;
        this.smsProcessor = smsProcessor;
    }

    @Override
    public void notify(String ownerEmail, String ownerPhone) {
        if (ownerEmail != null) {
            emailProcessor.send(ownerEmail, "Deed transfer confirmation");
        }
        if (ownerPhone != null) {
            smsProcessor.send(ownerPhone, "Deed transfer confirmation");
        }
    }
}