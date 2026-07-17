package solid.two.service;

public interface IPaymentProcessor {

    void processPayment(String ownerPhone, String paymentRef, double fee);
}