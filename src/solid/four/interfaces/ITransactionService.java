package solid.four.interfaces;

import solid.four.TransferRequest;

public interface ITransactionService {

    public void processTransaction(TransferRequest transferRequest);
}
