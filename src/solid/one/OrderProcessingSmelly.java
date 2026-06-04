package solid.one;

import solid.one.Item;
import solid.one.Order;

public class OrderProcessingSmelly {

    public void processOrder(Order order) {
        // Calculate total
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        // Apply discount
        if (order.getCustomerType().equals("VIP")) {
            total = total * 0.85;
        } else if (order.getCustomerType().equals("STAFF")) {
            total = total * 0.70;
        }

        // Process payment
        if (order.getPaymentMethod().equals("CARD")) {
            // call card gateway
            System.out.println("Charging card: " + order.getCardNumber());
        } else if (order.getPaymentMethod().equals("ECOCASH")) {
            // call EcoCash API
            System.out.println("Sending EcoCash to: " + order.getPhone());
        }

        // Send confirmation
        if (order.getContactMethod().equals("EMAIL")) {
            System.out.println("Sending email to " + order.getEmail());
        } else if (order.getContactMethod().equals("SMS")) {
            System.out.println("Sending SMS to " + order.getPhone());
        }

        // Save to DB
        System.out.println("Saving order " + order.getId() + " to database");
    }
}

//principles violated
//single responsibility, this method is doing almost everything, split the functionality
//Open Closed principle, this class has to be modified if we are to introduce a new gateway and
//DIP - High level classes eg servies must not depend to concrete implementations instead they must depend on abstractions
// eg PaymentService depends on PaymentProcessor where the actuak implementation is
//