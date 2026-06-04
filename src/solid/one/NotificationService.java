package solid.one;

public class NotificationService implements INotificationService{

    private final MessageProcessor messageProcessor;

    public NotificationService(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }



    @Override
    public void sendNotification(MessageDTO messageDTO) {
        messageProcessor.send(messageDTO);
    }
}
