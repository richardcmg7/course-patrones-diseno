
import entitys.Product;
import factorymethod.dao.ProductDAO;
import factorymethod.factory.DBAdapterFactory;
import factorymethod.factory.IDBAdapter;
import factorymethod.types.DBType;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author richa
 */
public class Main {
    public static void main(String[] args){
           //MySQLAdapter adapter = new MySQLAdapter();
           //PostgresAdapter adapter = new PostgresAdapter();
           
           Product product3 = new Product(31, "Producto 3", 50);
           ProductDAO dao = new ProductDAO();
           //dao.saveProduct(product3);
           List<Product> allProducts = dao.getAllProducts();
           for(Product current: allProducts){
            System.out.println(current);   
           }
    }
}
