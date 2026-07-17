package solid.four;

import solid.four.interfaces.ICurrencyConverterService;

class CurrencyConverter implements ICurrencyConverterService {
    public double convert(double amount, String from, String to) {
        System.out.println("Converting " + amount + " from " + from + " to " + to);
        return amount * 1.2;
    }
}