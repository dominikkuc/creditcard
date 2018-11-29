package pl.kuc;

import org.junit.Assert;
import org.junit.Test;
import pl.kuc.creditcard.CreditCard;
import pl.kuc.creditcard.exceptions.CardBlockedException;
import pl.kuc.creditcard.exceptions.LimitLowerThan100Exveption;
import pl.kuc.creditcard.exceptions.WithdrawOverBalanceException;
import pl.kuc.creditcard.exceptions.WithdrawOverLimitException;

public class CreditCardTest {
    private static final String id = "1234";

    @Test
    public void assignCreditLimitToCard() {
        CreditCard card = new CreditCard(id);

        try {
            card.assignLimit(2000);
        } catch (LimitLowerThan100Exveption e) {

        }
        Assert.assertTrue(card.getLimit() == 2000);
    }

    @Test(expected = WithdrawOverLimitException.class)
    public void rejectWithdrawOverLimit() throws Exception {
        CreditCard card = new CreditCard(id);
        card.refund(3000);
        card.withdraw(3000);
    }

    @Test(expected = WithdrawOverBalanceException.class)
    public void rejectWithdrawOverBalance() throws Exception {
        CreditCard card = new CreditCard(id);
        card.refund(500);
        card.withdraw(900);
    }

    @Test(expected = CardBlockedException.class)
    public void rejectWithdrawCardBlocked() throws Exception {
        CreditCard card = new CreditCard(id);
        card.refund(1000);
        card.lock();
        card.withdraw(500);
    }

    @Test(expected = LimitLowerThan100Exveption.class)
    public void reassignLimitLowerThan100() throws Exception {
        CreditCard card = new CreditCard();
        card.assignLimit(20);
    }

    @Test
    public void getLoan() {

        CreditCard card = new CreditCard();

        card.refund(300);
        card.getLoan(200);

        Assert.assertTrue(card.balance == 500);
    }
}
