package solid.two.service;

public interface IFeeCalculationService {


    double calculateFee(String deedType, double propertyValue, boolean isUrgent, boolean isVip);

}
