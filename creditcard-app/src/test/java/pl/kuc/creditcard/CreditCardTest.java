package pl.kuc.creditcard;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest {
    @Test
    public void assignCreditLimitToCard() {
        CreditCard card = new CreditCard();
        
        card.assignLimit(2000);
        
        Assert.assertTrue(card.getLimit() == 2000);
    }
}