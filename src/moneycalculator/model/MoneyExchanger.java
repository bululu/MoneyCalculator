package moneycalculator.model;

public class MoneyExchanger {
    public static Money Exchange(Money money, ExchangeRate exrate){
        return new Money(money.getAmount()*exrate.getRate(),exrate.getToCurrency());
    }
}
