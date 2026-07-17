package solid.one;

public class RegularDiscount extends Discount {

    @Override
    public double discountCalculator(double total) {
        return total;
    }
}