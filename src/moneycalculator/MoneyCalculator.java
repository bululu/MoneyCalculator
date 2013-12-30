package moneycalculator;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistence.DBCurrencySetLoader;
import moneycalculator.persistence.DBExchangeRateLoader;
import moneycalculator.ui.ApplicationFrame;

public class MoneyCalculator {

    public static void main(String[] args) {
        DBCurrencySetLoader CSL = new DBCurrencySetLoader();
        CurrencySet CS=CSL.load();
        DBExchangeRateLoader ERL = new DBExchangeRateLoader();
        ApplicationFrame AF= new ApplicationFrame();
        
  
        
    }
}
