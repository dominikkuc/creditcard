package pl.kuc.creditcard;

import org.junit.Assert;
import org.junit.Test;
import pl.kuc.creditcard.CreditCard;
import pl.kuc.creditcard.CreditCardApi;
import pl.kuc.creditcard.CreditCardRepository;
import pl.kuc.creditcard.exceptions.CardBlockedException;
import pl.kuc.creditcard.exceptions.WithdrawOverBalanceException;
import pl.kuc.creditcard.exceptions.WithdrawOverLimitException;
import pl.kuc.exchange.ExchangeRateChecker;

public class CreditCardApiTest {
    private static final double initialBalance = 200;
    private static final String id = "123412341234";
    private CreditCardRepository repository;
    private CreditCardApi api;

    @Test
    public void withdrawFromCard() throws WithdrawOverBalanceException, CardBlockedException, WithdrawOverLimitException {
        thereIsCreditCardRepository();
        thereIsCreditCardApi();
        thereIsCardWithId(id);

        api.withdraw(id, 20);
        balanceOfCardEquals(id, 180);
    }

    @Test
    public void withdrawFromCardInForeignCurrency() throws WithdrawOverBalanceException, CardBlockedException, WithdrawOverLimitException {
        thereIsCreditCardRepository();
        thereIsCreditCardApi();
        thereIsCardWithId(id);
        currentEuroExchangeIs(2.0);

        api.withdraw(id, 20, "EURO");
        balanceOfCardEquals(id, 160);
    }

    private void currentEuroExchangeIs(double currency) {
    }

    private void balanceOfCardEquals(String id, double balance) {
        CreditCard c = repository.find(id);

        Assert.assertEquals(
                balance,
                c.getBalance(),
                1e-15
        );
    }

    private void thereIsCreditCardRepository() {
        this.repository = new CreditCardRepository();
    }

    private void thereIsCreditCardApi() {
        this.api = new CreditCardApi(repository);
        new FakeRateChecker();
    }

    private void thereIsCardWithId(String id) {
        CreditCard c = new CreditCard(id);
        c.refund(initialBalance);
        repository.add(c);
    }
    private FakeRateChecker implements ExchangeRateChecker
    {
        public double getValueFor(String currency, double funds) {

        }
    }
}
