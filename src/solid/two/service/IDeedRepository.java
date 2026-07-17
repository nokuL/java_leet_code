package solid.two.service;

public interface IDeedRepository {

    void save(String ownerName, String deedType, double fee, ClerkType assignedClerk);
}