package moneycalculator.persistence;

import java.util.Currency;
import java.util.Date;
import moneycalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
    ExchangeRate load(Date date, Currency from, Currency to);
}
