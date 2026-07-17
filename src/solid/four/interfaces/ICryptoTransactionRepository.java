package solid.four.interfaces;

public interface ICryptoTransactionRepository {

    public void saveCryptoTransaction(String txHash, double amount);
}
