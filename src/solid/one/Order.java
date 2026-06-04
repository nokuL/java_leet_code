package solid.one;

import solid.one.Item;

import java.util.List;

public class Order {
    private String id;
    private List<Item> items;
    private String customerType;   // "VIP", "STAFF", "REGULAR"
    private String paymentMethod;  // "CARD", "ECOCASH"
    private String contactMethod;  // "EMAIL", "SMS"
    private String cardNumber;
    private String phone;
    private String email;

    public Order(String id, List<Item> items, String customerType,
                 String paymentMethod, String contactMethod,
                 String cardNumber, String phone, String email) {
        this.id = id;
        this.items = items;
        this.customerType = customerType;
        this.paymentMethod = paymentMethod;
        this.contactMethod = contactMethod;
        this.cardNumber = cardNumber;
        this.phone = phone;
        this.email = email;
    }

    public String getId() { return id; }
    public List<Item> getItems() { return items; }
    public String getCustomerType() { return customerType; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getContactMethod() { return contactMethod; }
    public String getCardNumber() { return cardNumber; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}