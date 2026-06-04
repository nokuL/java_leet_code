package solid.one;

public class SmsProcessor implements  MessageProcessor{
    @Override
    public void send(MessageDTO messageDTO) {
        System.out.println("Sending SMS to: " + messageDTO.getPhone() + " — " + messageDTO.getMessage());
    }
}
