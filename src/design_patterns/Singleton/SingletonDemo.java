package design_patterns.Singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        PaymentGatewayConnectionManager first = PaymentGatewayConnectionManager.getInstance();
        first.openConnection();

        PaymentGatewayConnectionManager second = PaymentGatewayConnectionManager.getInstance();
        second.openConnection();

        System.out.println("Same instance? " + (first == second));           // true
        System.out.println("Active connections: " + first.getActiveConnections()); // 2
    }
}