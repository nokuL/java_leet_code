package solid.two.service;

public class DeedRepository implements IDeedRepository {

    @Override
    public void save(String ownerName, String deedType, double fee, ClerkType assignedClerk) {
        System.out.println("Saving deed for: " + ownerName);
        System.out.println("Deed type: " + deedType);
        System.out.println("Fee charged: $" + fee);
        System.out.println("Assigned to: " + assignedClerk);
    }
}