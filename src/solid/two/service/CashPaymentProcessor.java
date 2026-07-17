package solid.two.service;

public class CashPaymentProcessor implements IPaymentProcessor {

    @Override
    public void processPayment(String ownerPhone, String paymentRef, double fee) {
        System.out.println("Cash payment recorded: $" + fee);
    }
}