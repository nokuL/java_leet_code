package solid.four;

import solid.four.interfaces.*;
import solid.four.repository.IAccountRepository;

public class PaymentProcessor {
    private final IAccountRepository db;
    private final INotificationService notificationService;
    private final IFraudDetectorService fraudDetector;
    private final ICurrencyConverterService currencyConverter;
    private final ITransferService transferService;
    private final ICryptoTransactionRepository cryptoTransactionRepository;

    public PaymentProcessor(IAccountRepository db, INotificationService email, IFraudDetectorService fraudDetector, ICurrencyConverterService currencyConverter, ITransferService transferService, ICryptoTransactionRepository cryptoTransactionRepository) {
        this.db = db;
        this.notificationService = email;
        this.fraudDetector = fraudDetector;
        this.currencyConverter = currencyConverter;
        this.transferService = transferService;
        this.cryptoTransactionRepository = cryptoTransactionRepository;
    }

    public void executeTransfer(TransferRequest request) {
        transferService.validateTransfer(request);

        double amountInUSD = request.getAmount();
        if (!request.getCurrency().equals("USD")) {
            amountInUSD = currencyConverter.convert(request.getAmount(), request.getCurrency(), "USD");
        }

        boolean fraudCheck = fraudDetector.check(request.getSourceAccount().getId(), amountInUSD);
        if (!fraudCheck) {
            System.out.println("Fraud alert for account: " + request.getSourceAccount().getId());
            notificationService.sendAlert(request.getSourceAccount().getOwnerEmail(), "Suspicious transaction blocked");
            return;
        }

        if (request.getType().equals("INTERNAL")) {
            Account src = request.getSourceAccount();
            Account tgt = request.getTargetAccount();
            src.setBalance(src.getBalance() - request.getAmount());
            tgt.setBalance(tgt.getBalance() + request.getAmount());
            db.updateAccount(src);
            db.updateAccount(tgt);
        } else if (request.getType().equals("EXTERNAL")) {
            ExternalBankApi api = new ExternalBankApi();
            boolean success = api.transfer(request.getTargetExternalId(), request.getAmount());
            if (!success) {
                throw new RuntimeException("External transfer failed");
            }
            Account src = request.getSourceAccount();
            src.setBalance(src.getBalance() - request.getAmount());
            db.updateAccount(src);
        } else if (request.getType().equals("CRYPTO")) {
            CryptoWallet wallet = new CryptoWallet();
            String txHash = wallet.send(request.getCryptoAddress(), request.getAmount());
            Account src = request.getSourceAccount();
            src.setBalance(src.getBalance() - request.getAmount());
            db.updateAccount(src);
            cryptoTransactionRepository.saveCryptoTransaction(txHash, request.getAmount());
        } else {
            throw new IllegalArgumentException("Unknown transfer type");
        }


        String msg = "Transfer of " + request.getAmount() + " " + request.getCurrency() + " completed.";
        notificationService.sendNotification(request.getSourceAccount().getOwnerEmail(), msg);
        notificationService.sendNotification(request.getTargetAccount().getOwnerEmail(), msg);


    }
}

//Principles broken

//Dependency Inversion: High Level Classes must not depend on concrete implementations but rather depend on abstractions, eg Database dabase = new Database()
//We are instantiating a new Database object , that means we also need to drag all the dependencies that Database class has , the same applies to all the others
//Rather use abstraction eg an interface called IDatabase , have  abstract methods that we can then call in our service. This gives us flexibility to add whatever new parameters we want , or test independently
//in this case there is tight coupling of the resources and dependencies


//Single Responsibility : A class must have only one reaseon to change i.e class must contain code for the same business context eg payments, transfer.
//In this case, this class is trying to implement code to send transfer, convert currencies and update transcations.
//Functionalities should be split into the various services

//Open Closed Principle : Classes must be open for extenstion and closed for modification. Meaning that once we write code in a certain class, it is not good practice to add new functionality
//by editing the code we've written before. Why ? to reduce the chance of introducing bugs , having to retest all the code the whole file instead of only the code that has changed

//Liskov Principle : The external , Internal and crypto transfer types were then modeled to implement the TransferTypeProcessor interface but external throws and unexpected excpetion
//this violates the liskov principle which states that Parent types must be substitutable with their subtypes, but in this case external behaves different from the
//expected prcesss method we expected. So i forced the implementing methods to throw the same custom exception whenever we have an exception or to return the sme result.
//

//Inteface Segragation : The db field here is one fat IDatabaseService interface with updateAccount, saveTransaction and saveCryptoTransaction all bundled together.
//Every class that needs the database is forced to depend on all three methods even though most of them only ever call one or two, eg internal and external transfers
//never touch saveCryptoTransaction, and nothing that logs a transaction needs saveCryptoTransaction either. This violates interface segregation which says clients
//should not be forced to depend on methods they don't use. So i split it into three narrow interfaces, IAccountRepository (updateAccount), ITransactionRepository
//(saveTransaction) and ICryptoTransactionRepository (saveCryptoTransaction), and each class now only depends on the ones it actually calls.