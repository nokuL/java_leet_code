package design_patterns.structural.strategy;

public class NoDiscount implements IDiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return 0;
    }
}
