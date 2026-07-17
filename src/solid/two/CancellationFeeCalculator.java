package solid.two;

public class CancellationFeeCalculator implements IDeedTypeProcessor {
    @Override
    public double calculateFee(double propertyValue) {
        return 500.0;
    }
}
