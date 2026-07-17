package solid.four.repository;

import solid.four.Transaction;

public interface ITransactionRepository {

    public void saveTransaction(Transaction tx);
}