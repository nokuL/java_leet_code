package solid.four;

import solid.four.interfaces.TransferTypeProcessor;
import solid.four.service.CryptoProcessorService;
import solid.four.service.ExternalTransferProcessor;
import solid.four.service.InternalTransferProcessor;

public class TransferTypeProcessorFactory {

    private final InternalTransferProcessor internalTransferProcessor;
    private final ExternalTransferProcessor externalTransferProcessor;
    private final CryptoProcessorService cryptoProcessorService;

    public TransferTypeProcessorFactory(InternalTransferProcessor internalTransferProcessor,
                                         ExternalTransferProcessor externalTransferProcessor,
                                         CryptoProcessorService cryptoProcessorService) {
        this.internalTransferProcessor = internalTransferProcessor;
        this.externalTransferProcessor = externalTransferProcessor;
        this.cryptoProcessorService = cryptoProcessorService;
    }

    public TransferTypeProcessor getProcessor(String transferType) {
        switch (transferType) {
            case "INTERNAL": return internalTransferProcessor;
            case "EXTERNAL": return externalTransferProcessor;
            case "CRYPTO":   return cryptoProcessorService;
            default: throw new IllegalArgumentException("Unknown transfer type: " + transferType);
        }
    }
}