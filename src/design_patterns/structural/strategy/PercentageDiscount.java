package design_patterns.structural.strategy;

public class PercentageDiscount implements IDiscountStrategy{

    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double price) {
        return price -(price *(percent/100));
    }
}
