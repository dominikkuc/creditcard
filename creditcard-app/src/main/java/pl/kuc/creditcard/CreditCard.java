package pl.kuc.creditcard;
public class CreditCard {
    private double limit;
    private double balance;
    
    public CreditCard() {
        limit = 0;
        balance = 0;
    }
    
    public void assignLimit(double limit) {
        this.limit = limit;
    }
    
    public double  getLimit() {
        return limit;
    }
}