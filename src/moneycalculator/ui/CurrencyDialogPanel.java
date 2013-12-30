package moneycalculator.ui;

import java.awt.FlowLayout;
import java.awt.PopupMenu;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog{

    public CurrencyDialogPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }

    
    
    @Override
    public Currency getCurrency() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createComponents() {
        this.add(createCombo());
       
    }

    private String[] getCurrencyNames() {
    CurrencySet CS=CurrencySet.getInstance();
    String[] currencyNames= new String[CS.size()];
        int i=0;
        for (Currency currency : CS) {
            currencyNames[i]=currency.getCode();
            i++;            
        }        
        return currencyNames;
    }

    private JComboBox createCombo() {
        return new JComboBox(getCurrencyNames());
    }
       
}
