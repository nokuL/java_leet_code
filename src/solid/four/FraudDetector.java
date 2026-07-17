package solid.four;

import solid.four.interfaces.IFraudDetectorService;

public class FraudDetector implements IFraudDetectorService {
    public boolean check(String accountId, double amount) {
        System.out.println("Checking fraud for " + accountId + " amount " + amount);
        return amount < 10000;
    }
}