package moneycalculator.model;

public class MoneyExchanger {
    public Money Exchange(Money money, ExchangeRate exrate){
        return new Money(money.getAmount()*exrate.getRate(),exrate.getToCurrency());
    }
}
