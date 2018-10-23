package pl.kuc.creditcard.exceptions;

public class WithdrawOverLimitException extends Exception {
    private double limit;
    private double funds;

    public WithdrawOverLimitException (double limit, double funds) {
        this.limit = limit;
        this.funds = funds;
    }

    public double getFunds() {
        return funds;
    }

    public double getLimit() {
        return limit;
    }
}
