package solid.one;

public class MessageDTO {
    private String message;
    private String phone;
    private String email;

    public MessageDTO(String message, String phone, String email) {
        this.message = message;
        this.phone = phone;
        this.email = email;
    }

    public String getMessage() { return message; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}
