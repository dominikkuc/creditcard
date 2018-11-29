package pl.kuc.creditcard;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration
class CreditCardConfiguration {

    @Bean
    public CreditCardApi creditCardApi() {
        CreditCardRepository repo = new CreditCardRepository();
        CreditCard c1 = new CreditCard("1234");
        CreditCard c2 = new CreditCard("DUPA");
        repo.add(c1);
        repo.add(c2);
        CreditCardApi api = new CreditCardApi(repo);
        return api;
    }
}