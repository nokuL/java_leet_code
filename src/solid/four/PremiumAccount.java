package solid.four;

class PremiumAccount extends Account {
    private double overdraftLimit = 5000;
    @Override
    public double getBalance() {
        return super.getBalance() + overdraftLimit;
    }
}