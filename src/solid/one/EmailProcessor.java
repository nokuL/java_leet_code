package solid.one;

public class EmailProcessor implements MessageProcessor{

    @Override
    public void send(MessageDTO messageDTO) {
        System.out.println("Sending email to: " + messageDTO.getEmail() + " — " + messageDTO.getMessage());
    }
}
