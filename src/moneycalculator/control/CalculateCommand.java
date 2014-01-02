package moneycalculator.control;

import moneycalculator.model.Money;
import moneycalculator.model.MoneyExchanger;
import moneycalculator.persistence.DBExchangeRateLoader;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyViewer;

public class CalculateCommand extends Command{

    public CalculateCommand(MoneyDialog mDialog, CurrencyDialog cDialog, MoneyViewer viewer) {
        this.mDialog = mDialog;
        this.cDialog = cDialog;
        this.viewer = viewer;
    }
    private final MoneyDialog mDialog;
    private final CurrencyDialog cDialog;
    private final MoneyViewer viewer;

    @Override
    public void execute() {
        viewer.show(new Money(calculateAmount(),cDialog.getCurrency()));        
    }

    private double calculateAmount() {
    DBExchangeRateLoader ER= new DBExchangeRateLoader();
        return MoneyExchanger.Exchange(mDialog.getMoney(), ER.load(mDialog.getMoney().getCurrency(), cDialog.getCurrency())).getAmount();
    }

}
