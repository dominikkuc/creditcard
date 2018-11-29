package pl.kuc.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CreditCardController {

    CreditCardApi api;

    @Autowired
    public CreditCardController(CreditCardApi api) {
        this.api = api;
    }

    @RequestMapping("/")
    public String index() {
        return "Credit Card works!";
    }

    @GetMapping("/{id}")
    public CardInfo cardBalance(@PathVariable String id) {
        CardInfo info = new CardInfo();
        info.id = id;
        info.balance = 3000;
        return info;
    }

    @PostMapping("/{id}/{money}")
    public void withdraw(
            @PathVariable String id,
            @PathVariable double money) {

        try {
            api.withdraw(id, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class CardInfo {
        public String id;
        public double balance;
    }
}
