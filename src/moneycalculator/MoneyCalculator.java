package moneycalculator;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistence.DBCurrencySetLoader;
import moneycalculator.persistence.DBExchangeRateLoader;

public class MoneyCalculator {

    public static void main(String[] args) {
        DBCurrencySetLoader CSL = new DBCurrencySetLoader();
        CurrencySet CS=CSL.load();
        DBExchangeRateLoader ERL = new DBExchangeRateLoader();
        int i=0;
        Currency from=(Currency) CS.toArray()[0];
        for (Currency currency : CS) {
            ExchangeRate ER=ERL.load(from, currency);
            System.out.println("RATES EXAMPLE");
            System.out.println("FROM "+ER.getFromCurrency().getCode()+" TO "+ER.getToCurrency().getCode()+" RATE "+ER.getRate());
        }
        
  
        
    }
}
