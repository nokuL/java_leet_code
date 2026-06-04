package solid.one;

public abstract class Discount implements IDiscountService {

    public abstract double discountCalculator(double total);


    public double applyDiscount(double total) {
        double discounted = discountCalculator(total);
        return Math.max(discounted, 0); // shared validation
    }

}

