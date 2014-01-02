package moneycalculator.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    private ActionListenerFactory factory;
    private CurrencyDialog cDialog;
    private MoneyDialog mDialog;
    private MoneyViewer viewer;

    public CurrencyDialog getcDialog() {
        return cDialog;
    }

    public MoneyDialog getmDialog() {
        return mDialog;
    }

    public MoneyViewer getViewer() {
        return viewer;
    }

    public ApplicationFrame(ActionListenerFactory factory) {
        this.setTitle("Money Calculator");
        this.factory= factory;
        this.setMinimumSize(new Dimension(300,170));
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
        MoneyDialogPanel mPanel= new MoneyDialogPanel();
        CurrencyDialogPanel cPanel= new CurrencyDialogPanel();
        MoneyViewerPanel mViewer= new MoneyViewerPanel();
        mDialog=mPanel;
        cDialog=cPanel;
        viewer=mViewer;
        panel.add(mPanel);
        panel.add(cPanel);
        panel.add(mViewer);
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
        button.addActionListener(factory.createActionListener("calculate"));
        return button;
    }

    private JButton createExitButton() {
    JButton button=new JButton("Exit");
        button.addActionListener(factory.createActionListener("exit"));
        return button;
    }
    

}
