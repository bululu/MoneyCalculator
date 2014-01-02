package moneycalculator.ui;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog{
    private String currency;

    public CurrencyDialogPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }

    
    
    @Override
    public Currency getCurrency() {
    CurrencySet CS=CurrencySet.getInstance();
        
        for (Currency currencyaux : CS) {
            if (currencyaux.getCode().equals(currency))
                return currencyaux;        
        }
        return null;
    }

    private void createComponents() {
        this.add(createCombo());
       
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

    private JComboBox createCombo() {
        JComboBox combo = new JComboBox(getCurrencyNames());
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED)
                    return;
                currency= (String) e.getItem();
            }
        });
        return combo;
    }
       
}
