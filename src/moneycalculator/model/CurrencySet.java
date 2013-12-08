package moneycalculator.model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{

    private static CurrencySet instance=null;
    
    private CurrencySet(){
        
    }
    
    private static void createInstance(){
        if (instance==null)
            instance=new CurrencySet();
    }
    
    public static CurrencySet getInstance(){
        createInstance();
        return instance;
    }
}
