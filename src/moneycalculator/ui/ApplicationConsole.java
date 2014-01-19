package moneycalculator.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import moneycalculator.control.CalculateCommand;

public class ApplicationConsole {

    private CurrencyDialog cDialog;
    private MoneyDialog mDialog;
    private MoneyViewer viewer;
    
    public ApplicationConsole() throws IOException {
        createComponents();       
    }
    
    private void createComponents() throws IOException {
        MoneyDialogConsole mConsole= new MoneyDialogConsole();
        CurrencyDialogConsole cConsole= new CurrencyDialogConsole();
        MoneyViewerConsole mViewer= new MoneyViewerConsole();
        
        System.out.println("Primero introduzca los datos de origen");
        mConsole.readNewValues();
        System.out.println("Ahora la divisa de destino");
        cConsole.readNewValues();
        mDialog=mConsole;
        cDialog=cConsole;
        viewer=mViewer;
        
        Integer option;
        do{
            option=showOptions();
            attendOption(option);
        } while (option!=5);
    }

    private Integer showOptions() throws IOException {
        System.out.println("Seleccione una opcion (inserte el numero)");
        System.out.println("1. Cambiar el origen");
        System.out.println("2. Cambiar el destino");
        System.out.println("3. Mostrar datos seleccionados");
        System.out.println("4. Calcular Datos");
        System.out.println("5. Salir");
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(buffer.readLine());
    }

    private void attendOption( Integer option) throws IOException {       
            switch(option){
                case 1: 
                    MoneyDialogConsole mD=(MoneyDialogConsole) mDialog;
                    mD.readNewValues();
                    break;
                case 2:
                    CurrencyDialogConsole cD=(CurrencyDialogConsole) cDialog;
                    cD.readNewValues();
                    break;
                case 3:
                    System.out.println("Datos de Origen");
                    System.out.println(mDialog.getMoney().toString());
                    System.out.println("Datos de destino");
                    System.out.println(cDialog.getCurrency().getName());
                    break;
                case 4:
                    CalculateCommand command =new CalculateCommand(mDialog, cDialog, viewer);
                    command.execute();
                    break;
            }       
    }   



}
