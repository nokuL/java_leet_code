package solid.four.service;

import solid.four.Account;
import solid.four.CryptoWallet;
import solid.four.TransferRequest;
import solid.four.TransferResult;
import solid.four.interfaces.ICryptoTransactionRepository;
import solid.four.interfaces.TransferTypeProcessor;
import solid.four.repository.IAccountRepository;

public class CryptoProcessorService implements TransferTypeProcessor {
    private final IAccountRepository db;
    private final ICryptoTransactionRepository cryptoLogger;

    public CryptoProcessorService(IAccountRepository db, ICryptoTransactionRepository cryptoLogger) {
        this.db = db;
        this.cryptoLogger = cryptoLogger;
    }

    @Override
    public TransferResult process(TransferRequest request) {
        CryptoWallet wallet = new CryptoWallet();
        String txHash = wallet.send(request.getCryptoAddress(), request.getAmount());
        Account src = request.getSourceAccount();
        src.setBalance(src.getBalance() - request.getAmount());
        String accountId = db.updateAccount(src);
        cryptoLogger.saveCryptoTransaction(txHash, request.getAmount());
        return new TransferResult(true, "sucess", accountId);
    }
}
