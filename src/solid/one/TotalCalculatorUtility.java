package solid.one;

public class TotalCalculatorUtility implements ITotalCalculator {

    public double totalCalculator(Order order){
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
