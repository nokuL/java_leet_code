package solid.two.service;

public class IveriPaymentProcessor implements IPaymentProcessor {

    private final String gatewayUrl;
    private final String terminalId;

    public IveriPaymentProcessor(String gatewayUrl, String terminalId) {
        this.gatewayUrl = gatewayUrl;
        this.terminalId = terminalId;
    }

    @Override
    public void processPayment(String ownerPhone, String paymentRef, double fee) {
        System.out.println("Charging iVeri card, ref: " + paymentRef +
                " via " + gatewayUrl + " [terminal: " + terminalId + "]");
    }
}