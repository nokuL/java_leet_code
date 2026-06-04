package solid.three.service;

public class EcocashProcessor implements  IPaymentProcessor{

    @Override
    public void processPayment(String  newOwnerNationalId) {
        System.out.println("Dialing EcoCash USSD for " + newOwnerNationalId  );
    }
}
