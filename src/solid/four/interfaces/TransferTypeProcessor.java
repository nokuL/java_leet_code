package solid.four.interfaces;

import solid.four.TransferException;
import solid.four.TransferRequest;
import solid.four.TransferResult;

public interface TransferTypeProcessor {

    public TransferResult process(TransferRequest transferRequest) throws TransferException;
}
