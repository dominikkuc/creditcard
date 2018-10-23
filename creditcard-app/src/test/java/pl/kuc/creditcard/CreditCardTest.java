package pl.kuc.creditcard;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.kuc.creditcard.exceptions.WithdrawOverBalanceException;
import pl.kuc.creditcard.exceptions.WithdrawOverLimitException;

public class CreditCardTest {
    @Test
    public void assignCreditLimitToCard() {
        CreditCard card = new CreditCard();

        card.assignLimit(2000);

        Assert.assertTrue(card.getLimit() == 2000);
    }

    @Test(expected = WithdrawOverLimitException.class)
    public void rejectWithdrawOverLimit() throws Exception {
        CreditCard card = new CreditCard();
        card.refund(3000);
        card.assignLimit(2000);
        card.withdraw(3000);
    }

    @Test(expected = WithdrawOverBalanceException.class)
    public void rejectWithdrawOverBalance() throws Exception {
        CreditCard card = new CreditCard();
        card.refund(500);
        card.assignLimit(2000);
        card.withdraw(1000);
    }
}