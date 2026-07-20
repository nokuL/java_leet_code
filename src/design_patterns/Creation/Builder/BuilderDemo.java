package design_patterns.Creation.Builder;

public class BuilderDemo {

    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest.Builder("merchant-001", 49.99)
                .currency("ZWG")
                .description("Subscription renewal")
                .customerEmail("customer@example.com")
                .build();

        System.out.println(request);

        Transaction transaction = new Transaction.Builder("1", 12)
                .transName("Nnnnn")
                .description("WWWWWW")
                .build();

        System.out.println(transaction);
    }
}