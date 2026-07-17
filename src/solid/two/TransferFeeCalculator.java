package solid.two;

public class TransferFeeCalculator implements IDeedTypeProcessor {

    @Override
    public double calculateFee(double propertyValue) {
        return propertyValue * 0.02;
    }
}
