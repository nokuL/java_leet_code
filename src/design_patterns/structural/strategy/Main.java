package design_patterns.structural.strategy;

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout(new PercentageDiscount(10));

        double price = 100;
        double finalPrice = checkout.total(price);

        System.out.println("Original price: " + price);
        System.out.println("Final price after discount: " + finalPrice);
    }
}