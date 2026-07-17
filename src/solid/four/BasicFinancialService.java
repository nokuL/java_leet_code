package solid.four;

import solid.four.Account;
import solid.four.FinancialService;

class BasicFinancialService implements FinancialService {
    @Override
    public void deposit(Account acc, double amount) {
        // logic
    }
    @Override
    public void withdraw(Account acc, double amount) {
        // logic
    }
    @Override
    public void transfer(Account from, Account to, double amount) {
        // logic
    }
    @Override
    public void payBill(Account acc, String biller, double amount) {
        throw new UnsupportedOperationException("Not supported");
    }
    @Override
    public void invest(Account acc, String product, double amount) {
        throw new UnsupportedOperationException("Not supported");
    }
    @Override
    public void getStatement(Account acc) {
        // logic
    }
}