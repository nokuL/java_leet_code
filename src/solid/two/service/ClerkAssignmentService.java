package solid.two.service;

public class ClerkAssignmentService implements IClerkAssignmentService {

    @Override
    public ClerkType assignClerk(String assignedClerk, boolean isVip) {
        if (assignedClerk == null || assignedClerk.equals("")) {
            return isVip ? ClerkType.SENIOR_CLERK : ClerkType.JUNIOR_CLERK;
        }
        return ClerkType.valueOf(assignedClerk);
    }
}