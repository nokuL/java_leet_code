package solid.four.service;

import solid.four.Account;
import solid.four.ExternalBankApi;
import solid.four.TransferRequest;
import solid.four.TransferResult;
import solid.four.interfaces.TransferTypeProcessor;
import solid.four.repository.IAccountRepository;

public class ExternalTransferProcessor  implements TransferTypeProcessor {
    private final IAccountRepository db;

    public ExternalTransferProcessor(IAccountRepository db) {
        this.db = db;
    }

    @Override
    public TransferResult process(TransferRequest request) {
        ExternalBankApi api = new ExternalBankApi();
        boolean success = api.transfer(request.getTargetExternalId(), request.getAmount());
        if (!success) {
            //throw new TransferProcessingException("External transfer failed");  //incase we want to go the exception route
            return new TransferResult(false, "External transfer failed", null);
        }
        Account src = request.getSourceAccount();
        src.setBalance(src.getBalance() - request.getAmount());
        String accountId = db.updateAccount(src);
        return new TransferResult(true, "sucess", accountId );
    }
}
