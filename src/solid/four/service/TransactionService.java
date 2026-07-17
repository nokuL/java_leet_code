package solid.four.service;

import solid.four.Transaction;
import solid.four.TransferRequest;
import solid.four.interfaces.ITransactionService;
import solid.four.repository.ITransactionRepository;

public class TransactionService implements ITransactionService {

    private final ITransactionRepository databaseService;

    public TransactionService(ITransactionRepository databaseService) {
        this.databaseService = databaseService;
    }


    @Override
    public void processTransaction(TransferRequest request) {
        Transaction tx = new Transaction();
        tx.setFrom(request.getSourceAccount().getId());
        tx.setTo(request.getTargetAccount() != null ? request.getTargetAccount().getId() : null);
        tx.setAmount(request.getAmount());
        tx.setCurrency(request.getCurrency());
        tx.setStatus("COMPLETED");
        databaseService.saveTransaction(tx);
    }
}
