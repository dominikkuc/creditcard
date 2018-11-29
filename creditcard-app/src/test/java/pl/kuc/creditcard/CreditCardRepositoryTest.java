package pl.kuc.creditcard;

import org.junit.Assert;
import org.junit.Test;
import pl.kuc.creditcard.CreditCard;
import pl.kuc.creditcard.CreditCardRepository;

public class CreditCardRepositoryTest {
    private static final String id = "DUPA";

    @Test
    public void allowAddAndLoadCreditCard() {
        CreditCard c = new CreditCard(id);
        CreditCardRepository repo = new CreditCardRepository();

        repo.add(c);
        CreditCard loaded = repo.find(id);
        Assert.assertEquals(loaded.getId(), id);
    }
}
