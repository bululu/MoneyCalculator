package moneycalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import moneycalculator.control.CalculateCommand;
import moneycalculator.control.Command;
import moneycalculator.model.CurrencySet;
import moneycalculator.persistence.DBCurrencySetLoader;
import moneycalculator.persistence.DBExchangeRateLoader;
import moneycalculator.ui.ActionListenerFactory;
import moneycalculator.ui.ApplicationConsole;
import moneycalculator.ui.ApplicationFrame;

public class MoneyCalculator {

    private HashMap<String,Command> commandMap;

    public static void main(String[] args) throws IOException {
        new MoneyCalculator().execute();
    }

    private void execute() throws IOException {
        DBCurrencySetLoader CSL = new DBCurrencySetLoader();
        CurrencySet CS=CSL.load();
        DBExchangeRateLoader ERL = new DBExchangeRateLoader();
        System.out.println("Seleccione una opcion (inserte el numero)");
        System.out.println("1. Consola");
        System.out.println("2. Swing");
        Integer opcion;
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
        opcion= Integer.parseInt(buffer.readLine());
        if(opcion==1)
            createApplicationConsole();
        else
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
    
    private void createApplicationConsole() throws IOException {
        ApplicationConsole console= new ApplicationConsole();
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
