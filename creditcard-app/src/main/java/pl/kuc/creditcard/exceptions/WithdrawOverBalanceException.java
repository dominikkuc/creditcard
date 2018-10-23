package pl.kuc.creditcard.exceptions;

public class WithdrawOverBalanceException extends Exception {
    private double balance;
    private double funds;

    public WithdrawOverBalanceException (double balance, double funds) {
        this.balance = balance;
        this.funds = funds;
    }

    public double getFunds() {
        return funds;
    }

    public double getBalance() {
        return balance;
    }
}
