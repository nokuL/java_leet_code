package solid.one;

public class DiscountFactory {

    public IDiscountService getDiscount(String customerType) {
        switch (customerType) {
            case "VIP":   return new VIPDiscount();
            case "STAFF": return new StaffDiscount();
            default:      return new RegularDiscount();
        }
    }
}