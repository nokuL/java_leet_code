package solid.one;

public class VIPDiscount extends Discount {

    @Override
    public double discountCalculator(double total) {
        return total * 0.85;
    }
}
