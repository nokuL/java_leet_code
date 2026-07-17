package solid.four;

import solid.four.interfaces.*;

public class PaymentProcessorCorrect {

    private final ITransferService transferService;
    private final ICurrencyConverterService currencyConverter;
    private final IFraudDetectorService fraudDetector;
    private final INotificationService notificationService;
    private final TransferTypeProcessorFactory transferTypeProcessorFactory;

    public PaymentProcessorCorrect(ITransferService transferService,
                                    ICurrencyConverterService currencyConverter,
                                    IFraudDetectorService fraudDetector,
                                    INotificationService notificationService,
                                    TransferTypeProcessorFactory transferTypeProcessorFactory) {
        this.transferService = transferService;
        this.currencyConverter = currencyConverter;
        this.fraudDetector = fraudDetector;
        this.notificationService = notificationService;
        this.transferTypeProcessorFactory = transferTypeProcessorFactory;
    }

    public TransferResult executeTransfer(TransferRequest request) throws TransferException {
        transferService.validateTransfer(request);

        double amountInUSD = request.getAmount();
        if (!request.getCurrency().equals("USD")) {
            amountInUSD = currencyConverter.convert(request.getAmount(), request.getCurrency(), "USD");
        }

        boolean fraudCheck = fraudDetector.check(request.getSourceAccount().getId(), amountInUSD);
        if (!fraudCheck) {
            notificationService.sendAlert(request.getSourceAccount().getOwnerEmail(), "Suspicious transaction blocked");
            return new TransferResult(false, "Blocked: suspicious transaction", null);
        }

        TransferTypeProcessor processor = transferTypeProcessorFactory.getProcessor(request.getType());

        TransferResult result = processor.process(request);

        if (result.isSuccess()) {
            String msg = "Transfer of " + request.getAmount() + " " + request.getCurrency() + " completed.";
            notificationService.sendNotification(request.getSourceAccount().getOwnerEmail(), msg);
            if (request.getTargetAccount() != null) {
                notificationService.sendNotification(request.getTargetAccount().getOwnerEmail(), msg);
            }
        } else {
            notificationService.sendAlert(request.getSourceAccount().getOwnerEmail(), "Transfer failed: " + result.getMessage());
        }

        return result;
    }
}