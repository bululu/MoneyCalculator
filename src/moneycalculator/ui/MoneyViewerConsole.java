package moneycalculator.ui;

import moneycalculator.model.Money;

public class MoneyViewerConsole implements MoneyViewer {

    @Override
    public void show(Money money) {
        System.out.println(money.toString());
    }

}
