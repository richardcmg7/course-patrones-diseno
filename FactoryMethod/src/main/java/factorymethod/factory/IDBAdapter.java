package factorymethod.factory;

import java.sql.Connection;

/**
 *
 * @author richa
 */
public interface IDBAdapter {
    public Connection getConnection();
}
