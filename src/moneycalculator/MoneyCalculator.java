package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import moneycalculator.control.CalculateCommand;
import moneycalculator.control.Command;
import moneycalculator.model.CurrencySet;
import moneycalculator.persistence.DBCurrencySetLoader;
import moneycalculator.persistence.DBExchangeRateLoader;
import moneycalculator.ui.ActionListenerFactory;
import moneycalculator.ui.ApplicationFrame;

public class MoneyCalculator {

    private HashMap<String,Command> commandMap;

    public static void main(String[] args) {
        new MoneyCalculator().execute();
    }

    private void execute() {
        DBCurrencySetLoader CSL = new DBCurrencySetLoader();
        CurrencySet CS=CSL.load();
        DBExchangeRateLoader ERL = new DBExchangeRateLoader();
        createCommands(createApplicationFrame());
    }
    
    private void createCommands(ApplicationFrame frame) {
        commandMap= new HashMap<>();
        commandMap.put("exit", new Command() {

            @Override
            public void execute() {
                System.exit(0);
            }
        });
        commandMap.put("calculate", new CalculateCommand(frame.getmDialog(), frame.getcDialog(), frame.getViewer()));
    }
    
    private ApplicationFrame createApplicationFrame() {
        return new ApplicationFrame(new ActionListenerFactory() {

              @Override
              public ActionListener createActionListener(final String action) {
                  return new ActionListener() {

                      @Override
                      public void actionPerformed(ActionEvent e) {
                      Command command = commandMap.get(action);
                        if (command == null)
                            return;
                        command.execute();
                      }
                  };
              }
        });
    }

}
