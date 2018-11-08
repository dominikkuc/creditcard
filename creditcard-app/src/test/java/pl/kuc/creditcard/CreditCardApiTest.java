package pl.kuc.creditcard;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardApiTest {
    private static final double initialBalance = 200;
    private static final String id = "123412341234";
    private CreditCardRepository repository;
    private CreditCardApi api;

    @Test
    public void withdrawFromCard() {
        thereIsCreditCardApi();
        thereIsCreditCardRepository();
        thereIsCardWithId(id);

        api.withdraw(id, 20);
        balanceOfCardEquals(id, 180);
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
        this.api = new CreditCardApi();
    }

    private void thereIsCardWithId(String id) {
        CreditCard c = new CreditCard(id);
        c.assignLimit(initialBalance);
        repository.add(c);
    }
}
