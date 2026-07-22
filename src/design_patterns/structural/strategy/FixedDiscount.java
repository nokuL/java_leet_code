package design_patterns.structural.strategy;

public class FixedDiscount implements IDiscountStrategy{

    private int discount;

    public FixedDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discount;
    }
}
