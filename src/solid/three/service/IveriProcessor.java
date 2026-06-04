package solid.three.service;

public class IveriProcessor implements IPaymentProcessor{
    @Override
    public void processPayment( String newOwnerNationalId) {
        System.out.println("Iveri processing .......");
    }
}
