package solid.four;

public class TransferResult {
    private final boolean success;
    private final String message;
    private final String transactionId;

    public TransferResult(boolean success, String message, String transactionId) {
        this.success = success;
        this.message = message;
        this.transactionId = transactionId;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public String getTransactionId() { return transactionId; }
}
