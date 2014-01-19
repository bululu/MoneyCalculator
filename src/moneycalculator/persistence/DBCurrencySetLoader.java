package moneycalculator.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class DBCurrencySetLoader implements CurrencySetLoader {
    private static final String URL="jdbc:oracle:thin:@192.168.211.13:1521:orcl";
    private static final String USER="system";
    private static final String PASSWORD="orcl";

     @Override
    public CurrencySet load() {
        CurrencySet CS=CurrencySet.getInstance();
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("Select * from Divisas");
            while (resultset.next())
                CS.add(new Currency(resultset.getString("divisa"),resultset.getString("nombre"),resultset.getString("simbolo")));
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBCurrencySetLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CS;
    }  
}
