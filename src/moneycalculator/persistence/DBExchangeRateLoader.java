package moneycalculator.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public class DBExchangeRateLoader implements ExchangeRateLoader {
    private static final String URL="jdbc:oracle:thin:@192.168.211.17:1521:orcl";
    private static final String USER="system";
    private static final String PASSWORD="orcl";

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        double eurovsfrom=1;
        double eurovsto=1;
       
            if (!from.getCode().equals("EUR"))
                eurovsfrom=getCambioVsEuro(from.getCode());
            if (!to.getCode().equals("EUR"))
                eurovsto=getCambioVsEuro(to.getCode());
            
        return new ExchangeRate(new Date(), from, to, eurovsto/eurovsfrom);
    }

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        double eurovsfrom=1;
        double eurovsto=1;
       
            if (!from.getCode().equals("EUR"))
                eurovsfrom=getCambioVsEuroUpToDate(from.getCode(),date);
            if (!to.getCode().equals("EUR"))
                eurovsto=getCambioVsEuroUpToDate(to.getCode(),date);
            
        return new ExchangeRate(date, from, to, eurovsto/eurovsfrom);
    }

    private double getCambioVsEuro(String code) {        
        double cambio=1;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement= connection.createStatement();
            ResultSet resultset= statement.executeQuery("select cambio from cambio_eur_a where rownum<=1 and divisa='"+code+"' order by alta desc");
            resultset.next();
            cambio=resultset.getDouble("Cambio");
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBExchangeRateLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cambio;
    }
    
      private double getCambioVsEuroUpToDate(String code, Date date) {        
        double cambio=1;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement= connection.createStatement();
            ResultSet resultset= statement.executeQuery("select cambio from cambio_eur_a where rownum<=1 and divisa='"+code+"' and alta='"+date.toString()+"' order by alta desc");
            resultset.next();
            cambio=resultset.getDouble("Cambio");
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBExchangeRateLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cambio;
    }
}
