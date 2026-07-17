package solid.two;

public class MortgageFeeCalculator implements IDeedTypeProcessor {

    @Override
    public double calculateFee(double propertyValue) {
        return propertyValue * 0.015;
    }
}
