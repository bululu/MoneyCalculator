package moneycalculator.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    public ApplicationFrame() {
        this.setTitle("Money Calculator");
        this.setMinimumSize(new Dimension(300,130));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createContent());
        this.add(createToolBar(),BorderLayout.SOUTH);
    }

    private JPanel createContent() {
        JPanel panel= new JPanel();
        panel.add(new MoneyDialogPanel());
        panel.add(new CurrencyDialogPanel());
        return panel;
    }

    private Component createToolBar() {
        JPanel panel= new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;
    }

    private JButton createCalculateButton() {
    JButton button=new JButton("Calculate");
        return button;
    }

    private JButton createExitButton() {
    JButton button=new JButton("Exit");
        return button;
    }
    

}
