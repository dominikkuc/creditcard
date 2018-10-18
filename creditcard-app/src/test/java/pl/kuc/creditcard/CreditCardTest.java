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
    
    @Test
    public void rejectWithdrawOverLimit() {
        CreditCard card = new CreditCard();
        card.refund(3000);
        card.assignLimit(2000);
        Assert.assert card.withdraw(3000);
        
    }
}