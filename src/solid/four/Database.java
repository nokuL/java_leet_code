package solid.four;

import solid.four.interfaces.ICryptoTransactionRepository;
import solid.four.repository.IAccountRepository;
import solid.four.repository.ITransactionRepository;

public class Database implements IAccountRepository, ITransactionRepository, ICryptoTransactionRepository {
    public String updateAccount(Account acc) {
        System.out.println("Updating account: " + acc.getId());
        return null;
    }
    public void saveTransaction(Transaction tx) {
        System.out.println("Saving transaction");
    }
    public void saveCryptoTransaction(String txHash, double amount) {
        System.out.println("Saving crypto tx: " + txHash);
    }
}