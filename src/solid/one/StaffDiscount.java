package solid.one;

public class StaffDiscount extends Discount {

    @Override
    public double discountCalculator(double total) {
        return total * 0.70;
    }
}
