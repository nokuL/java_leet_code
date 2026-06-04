package solid.two.service;

import solid.two.DeedTypeProcessorFactory;
import solid.two.IDeedTypeProcessor;

public class FeeCalculationService implements IFeeCalculationService {

    private final DeedTypeProcessorFactory factory;

    public FeeCalculationService(DeedTypeProcessorFactory factory) {
        this.factory = factory;
    }

    @Override
    public double calculateFee(String deedType, double propertyValue, boolean isUrgent, boolean isVip) {
        IDeedTypeProcessor processor = factory.getProcessor(deedType);
        double fee = processor.calculateFee(propertyValue);
        if (isUrgent) fee = fee + (fee * 0.30);
        if (isVip)    fee = fee * 0.85;
        return fee;
    }
}
