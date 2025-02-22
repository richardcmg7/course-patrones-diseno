package factorymethod.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Oscar Blancarte <oscarblancarte3@gmail.com>
 */
public class MySQLAdapter implements IDBAdapter{
    
    static{
        try {
            new com.mysql.cj.jdbc.Driver();
        } catch (SQLException e) {}
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = getConnectionString();
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    private String getConnectionString(){
        return "jdbc:mysql://localhost:3306/sample_db?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    }
}
