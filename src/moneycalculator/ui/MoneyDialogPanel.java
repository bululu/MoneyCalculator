package moneycalculator.ui;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.model.Money;

public class MoneyDialogPanel extends JPanel implements MoneyDialog {
    private String amount="0";
    private CurrencyDialog currencyDialog;

    public MoneyDialogPanel() {
    CurrencyDialogPanel panel = new CurrencyDialogPanel();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createTextField());
        currencyDialog=panel;
        this.add(panel);
    }

    @Override
    public Money getMoney() {
        return new Money(Double.parseDouble(amount), currencyDialog.getCurrency());
    }

    private JTextField createTextField() {
    final JTextField field= new JTextField(10);
        field.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            amount= field.getText();
        }
    });
        return field;
    }

}
