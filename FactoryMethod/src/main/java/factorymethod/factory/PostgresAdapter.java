
package factorymethod.factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author richa
 */
public class PostgresAdapter implements IDBAdapter{

    static{
        try {
            new org.postgresql.Driver();
        } catch (Exception e) {}
    }
    @Override
    public Connection getConnection() {
        try {
             String connectionString = getConnectionString();
            String user = "user";
            String password = "password";
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private String getConnectionString(){
        return "jdbc:postgresql://localhost:5432/sample_db";
    }
}
