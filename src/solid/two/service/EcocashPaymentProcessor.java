package solid.two.service;

public class EcocashPaymentProcessor implements IPaymentProcessor {

    private final String apiUrl;
    private final String merchantId;

    public EcocashPaymentProcessor(String apiUrl, String merchantId) {
        this.apiUrl = apiUrl;
        this.merchantId = merchantId;
    }

    @Override
    public void processPayment(String ownerPhone, String paymentRef, double fee) {
        System.out.println("Sending EcoCash request to: " + ownerPhone +
                " via " + apiUrl + " [merchant: " + merchantId + "]");
    }
}