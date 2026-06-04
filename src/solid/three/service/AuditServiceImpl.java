package solid.three.service;

public class AuditServiceImpl  implements  IAuditService{


    @Override
    public void audit(String deedId, String newOwnerNationalId) {
        System.out.println("AUDIT: Deed " + deedId +
                " transferred to " + newOwnerNationalId +
                " at " + java.time.LocalDateTime.now());
    }
}
