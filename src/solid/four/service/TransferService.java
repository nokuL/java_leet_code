package solid.four.service;

import solid.four.TransferRequest;
import solid.four.interfaces.ITransferService;

public class TransferService implements ITransferService {
    @Override
    public void validateTransfer(TransferRequest transferRequest) {
        if (transferRequest.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (transferRequest.getSourceAccount() == null || transferRequest.getTargetAccount() == null) {
            throw new IllegalArgumentException("Missing accounts");
        }
        if (transferRequest.getSourceAccount().getBalance() < transferRequest.getAmount()) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
