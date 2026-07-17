package solid.four;

import solid.four.Account;

interface FinancialService {
    void deposit(Account acc, double amount);
    void withdraw(Account acc, double amount);
    void transfer(Account from, Account to, double amount);
    void payBill(Account acc, String biller, double amount);
    void invest(Account acc, String product, double amount);
    void getStatement(Account acc);
}