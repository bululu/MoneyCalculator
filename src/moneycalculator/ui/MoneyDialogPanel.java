package moneycalculator.ui;

import java.awt.FlowLayout;
import java.awt.PopupMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Money;

public class MoneyDialogPanel extends JPanel implements MoneyDialog {

    public MoneyDialogPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createTextField());
        this.add(new CurrencyDialogPanel());
    }

    @Override
    public Money getMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JTextField createTextField() {
    JTextField field= new JTextField(10);
        return field;
    }

}
