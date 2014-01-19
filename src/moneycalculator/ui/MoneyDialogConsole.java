package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.model.Money;

public class MoneyDialogConsole implements MoneyDialog{
    private String amount="0";
    private CurrencyDialog currencyDialog;

    public MoneyDialogConsole() {
        amount="0";
        currencyDialog=new CurrencyDialogConsole();
    }
    
    public void readNewValues() throws IOException{
        System.out.println("Introduzca la cantidad de dinero");
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
        amount= buffer.readLine();
        CurrencyDialogConsole cr =(CurrencyDialogConsole) currencyDialog;
        cr.readNewValues();
    }


    @Override
    public Money getMoney() {
        return new Money(Double.parseDouble(amount), currencyDialog.getCurrency());
    }

}
