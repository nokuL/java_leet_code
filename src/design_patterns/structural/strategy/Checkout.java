package design_patterns.structural.strategy;

public class Checkout {

    private final IDiscountStrategy discountStrategy;

    public Checkout(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double total(double price){
        return discountStrategy.applyDiscount(price);
    }
}
