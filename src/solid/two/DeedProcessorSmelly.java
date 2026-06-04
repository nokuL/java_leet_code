package solid.two;

public class DeedProcessorSmelly {

    public void processDeed(String deedType, String ownerName,
                            String ownerEmail, String ownerPhone,
                            double propertyValue, String paymentMethod,
                            String paymentRef, boolean isVip,
                            boolean isUrgent, String assignedClerk) {

        validateDeed(ownerName, ownerEmail, propertyValue);



        // Calculate fees
        double fee = 0;
        if (deedType.equals("TRANSFER")) {
            fee = propertyValue * 0.02;
        } else if (deedType.equals("MORTGAGE")) {
            fee = propertyValue * 0.015;
        } else if (deedType.equals("CANCELLATION")) {
            fee = 500.00;
        }

        // Apply urgency surcharge
        if (isUrgent) {
            fee = fee + (fee * 0.30);
        }

        // Apply VIP discount
        if (isVip) {
            fee = fee * 0.85;
        }

        // Process payment
        if (paymentMethod.equals("ECOCASH")) {
            System.out.println("Sending EcoCash request to: " + ownerPhone);
        } else if (paymentMethod.equals("IVERI")) {
            System.out.println("Charging iVeri card, ref: " + paymentRef);
        } else if (paymentMethod.equals("CASH")) {
            System.out.println("Cash payment recorded: $" + fee);
        }

        // Assign clerk
        if (assignedClerk == null || assignedClerk.equals("")) {
            if (isVip) {
                assignedClerk = "SENIOR_CLERK";
            } else {
                assignedClerk = "JUNIOR_CLERK";
            }
        }

        // Save deed
        System.out.println("Saving deed for: " + ownerName);
        System.out.println("Deed type: " + deedType);
        System.out.println("Fee charged: $" + fee);
        System.out.println("Assigned to: " + assignedClerk);

        // Notify
        if (ownerEmail != null) {
            System.out.println("Sending confirmation email to: " + ownerEmail);
        }
        if (ownerPhone != null) {
            System.out.println("Sending SMS to: " + ownerPhone);
        }
    }

    public boolean validateDeed(String ownerName, String ownerEmail, double propertyValue) {

        // Validate
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

        return  true;

    }
}