package solid.three.service;

public class NationalIdService implements INationalIdService{

    @Override
    public boolean validateiD(String newOwnerNationalId) {
        // 2. Validate new owner inline
        if (newOwnerNationalId == null || newOwnerNationalId.length() != 11) {
            return false;
        }
        if (!newOwnerNationalId.matches("[0-9]+")) {
            return false;
        }
        return true;
    }
}
