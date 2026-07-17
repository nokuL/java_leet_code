package solid.four;

public class ExternalBankApi {
    public boolean transfer(String externalId, double amount) {
        System.out.println("External transfer to " + externalId + " for " + amount);
        return true;
    }
}
