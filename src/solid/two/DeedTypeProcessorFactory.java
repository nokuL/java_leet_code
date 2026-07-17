package solid.two;

public class DeedTypeProcessorFactory {

    public IDeedTypeProcessor getProcessor(String deedType) {
        switch (deedType) {
            case "TRANSFER":     return new TransferFeeCalculator();
            case "MORTGAGE":     return new MortgageFeeCalculator();
            case "CANCELLATION": return new CancellationFeeCalculator();
            default: throw new IllegalArgumentException("Unknown deed type: " + deedType);
        }
    }
}