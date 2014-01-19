package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencyDialogConsole implements CurrencyDialog {
     private String currency;
     
    @Override
    public Currency getCurrency() {
         CurrencySet CS=CurrencySet.getInstance();
        
        for (Currency currencyaux : CS) {
            if (currencyaux.getCode().equals(currency))
                return currencyaux;        
        }
        return null;
    }
    
    private String[] getCurrencyNames() {
    CurrencySet CS=CurrencySet.getInstance();
    String[] currencyNames= new String[CS.size()];
        int i=0;
        for (Currency currencyaux : CS) {
            currencyNames[i]=currencyaux.getCode();
            i++;            
        }
        currency=currencyNames[0];
        return currencyNames;
    }
    
     public void readNewValues() throws IOException{
        String currencyNames[]=getCurrencyNames();
        int i=0;
        System.out.println("Elija una divisa (introduciendo su numero)");
         for (String string : currencyNames) {
             System.out.println(i+". "+currencyNames[i]);
             i++;
         }
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
        currency= currencyNames[Integer.parseInt(buffer.readLine())];
    }

}
