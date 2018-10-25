package pl.kuc.creditcard.exceptions;

public class LimitLowerThan100Exveption extends Exception {
    private double limit;

    public LimitLowerThan100Exveption (double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }
}
