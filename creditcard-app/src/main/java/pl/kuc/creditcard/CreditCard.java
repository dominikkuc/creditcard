package pl.kuc.creditcard;

import pl.kuc.creditcard.exceptions.CardBlockedException;
import pl.kuc.creditcard.exceptions.LimitLowerThan100Exveption;
import pl.kuc.creditcard.exceptions.WithdrawOverBalanceException;
import pl.kuc.creditcard.exceptions.WithdrawOverLimitException;

public class CreditCard {
    private double limit;
    private double balance;
    private boolean blockade;
    private String id;

    public CreditCard(String id) {
        limit = 1000;
        balance = 0;
        blockade = false;
        this.id = id;
    }

    public void assignLimit(double limit) throws LimitLowerThan100Exveption {
        if (limit < 100) {
            throw new LimitLowerThan100Exveption(limit);
        }
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public void refund(double funds) {
        balance += funds;
    }

    public void withdraw(double funds) throws WithdrawOverLimitException, WithdrawOverBalanceException, CardBlockedException {
        if (blockade) {
            throw new CardBlockedException();
        }
        if (funds > limit) {
            throw new WithdrawOverLimitException(limit, funds);
        }
        if (funds > balance) {
            throw new WithdrawOverBalanceException(balance, funds);
        }
        balance -= funds;
    }

    public void lock() {
        blockade = true;
    }

    public String getId() {
        return id;
    }
}