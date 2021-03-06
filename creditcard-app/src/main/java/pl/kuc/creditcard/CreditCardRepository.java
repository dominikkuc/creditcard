package pl.kuc.creditcard;

import java.util.HashMap;
import java.util.Map;

public class CreditCardRepository {
    private Map<String, CreditCard> cards = new HashMap<String, CreditCard>();

    public void add(CreditCard c) {
        cards.put(c.getId(), c);
    }

    public CreditCard find(String id) {
        return cards.get(id);
    }
}
