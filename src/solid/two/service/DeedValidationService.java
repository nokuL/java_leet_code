package solid.two.service;

public class DeedValidationService implements IDeedValidationService {

    @Override
    public boolean validate(String ownerName, String ownerEmail, double propertyValue) {
        if (ownerName == null || ownerName.equals("")) {
            System.out.println("Error: owner name is required");
            return false;
        }
        if (ownerEmail == null || !ownerEmail.contains("@")) {
            System.out.println("Error: invalid email");
            return false;
        }
        if (propertyValue <= 0) {
            System.out.println("Error: property value must be positive");
            return false;
        }
        return true;
    }
}