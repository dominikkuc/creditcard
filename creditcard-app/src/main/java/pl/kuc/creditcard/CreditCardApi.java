package pl.kuc.creditcard;

import pl.kuc.creditcard.exceptions.CardBlockedException;
import pl.kuc.creditcard.exceptions.WithdrawOverBalanceException;
import pl.kuc.creditcard.exceptions.WithdrawOverLimitException;

public class CreditCardApi {
    private CreditCardRepository repository;

    public CreditCardApi(CreditCardRepository repository) {
        this.repository = repository;
    }

    public void withdraw(String id, double funds) throws WithdrawOverBalanceException, CardBlockedException, WithdrawOverLimitException {
        CreditCard c = repository.find(id);
        c.withdraw(funds);
    }
}
