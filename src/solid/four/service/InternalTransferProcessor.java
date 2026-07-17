package solid.four.service;

import solid.four.Account;
import solid.four.TransferRequest;
import solid.four.TransferResult;
import solid.four.interfaces.TransferTypeProcessor;
import solid.four.repository.IAccountRepository;

public class InternalTransferProcessor implements TransferTypeProcessor {

    private final IAccountRepository db;

    public InternalTransferProcessor(IAccountRepository db) {
        this.db = db;
    }

    @Override
    public TransferResult process(TransferRequest request) {
        Account src = request.getSourceAccount();
        Account tgt = request.getTargetAccount();
        src.setBalance(src.getBalance() - request.getAmount());
        tgt.setBalance(tgt.getBalance() + request.getAmount());
        String accountId = db.updateAccount(src);
        return new TransferResult(true, "sucess", accountId);
    }
}
