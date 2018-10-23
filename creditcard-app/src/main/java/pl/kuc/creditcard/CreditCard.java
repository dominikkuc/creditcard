package pl.kuc.creditcard;

import pl.kuc.creditcard.exceptions.WithdrawOverBalanceException;
import pl.kuc.creditcard.exceptions.WithdrawOverLimitException;

public class CreditCard {
    private double limit;
    private double balance;

    public CreditCard() {
        limit = 0;
        balance = 0;
    }

    public void assignLimit(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void refund(double funds) {
        balance += funds;
    }

    public void withdraw(double funds) throws WithdrawOverLimitException, WithdrawOverBalanceException {
        if (funds > limit) {
            throw new WithdrawOverLimitException(limit, funds);
        }
        if (funds > balance) {
            throw new WithdrawOverBalanceException(balance, funds);
        }
        balance -= funds;
    }
}