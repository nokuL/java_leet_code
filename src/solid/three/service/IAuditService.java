package solid.three.service;

public interface IAuditService {

    void audit(String deedId, String newOwnerNationalId);
}
