package solid.four.interfaces;

public interface IFraudDetectorService {
    public boolean check(String accountId, double amount);
}
