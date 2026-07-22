package design_patterns.Singleton;

public class PaymentGatewayConnectionManager {

    // volatile so a partially-constructed instance is never seen by another thread
    private static volatile PaymentGatewayConnectionManager instance;

    private int activeConnections;

    // private constructor - only this class can create an instance
    private PaymentGatewayConnectionManager() {
        this.activeConnections = 0;
    }

    public static PaymentGatewayConnectionManager getInstance() {
        if (instance == null) {                                  // 1st check, no locking - fast path
            synchronized (PaymentGatewayConnectionManager.class) {
                if (instance == null) {                           // 2nd check, inside the lock
                    instance = new PaymentGatewayConnectionManager();
                }
            }
        }
        return instance;
    }

    public void openConnection() {
        activeConnections++;
    }

    public void closeConnection() {
        activeConnections--;
    }

    public int getActiveConnections() {
        return activeConnections;
    }
}