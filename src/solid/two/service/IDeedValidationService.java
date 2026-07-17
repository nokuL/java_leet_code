package solid.two.service;

public interface IDeedValidationService {

    boolean validate(String ownerName, String ownerEmail, double propertyValue);
}