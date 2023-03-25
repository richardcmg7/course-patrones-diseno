package factorymethod.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;


/**
 *
 * @author richa
 */
public class DBAdapterFactory {
    private static final String DB_TYPE = "dbadaptertype";
    public static IDBAdapter getAdapter(){
        try {
            Properties p = loadProperties();
            String dbtype = p.getProperty(DB_TYPE);
             Class<?> adapterClass = Class.forName(dbtype);
            Constructor<?> constructor = adapterClass.getDeclaredConstructor();
            return (IDBAdapter) constructor.newInstance();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static Properties loadProperties() throws IOException{
        Properties p = new Properties();
        FileInputStream ip;
        try {
             ip = new FileInputStream("src/main/resources/META-INF/dbadapter.properties");
             p.load(ip);
            return p;
        } catch(FileNotFoundException e){
                e.printStackTrace();
                return null;
        }
    }
}
