package solid.two.service;

public interface IPaymentService {

    void processPayment(String paymentMethod, String ownerPhone, String paymentRef, double fee);
}