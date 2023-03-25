/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorymethod.dao;

import entitys.Product;
import factorymethod.factory.DBAdapterFactory;
import factorymethod.factory.IDBAdapter;
import factorymethod.types.DBType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author richa
 */
public class ProductDAO {
    private final IDBAdapter adapter;
    public ProductDAO() {
        adapter = DBAdapterFactory.getAdapter();
    }
    public void saveProduct(Product product){
        try {
        String sql = "insert into productos values (?,?,?)";
        Connection connection = adapter.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
       
    }
    
    public List<Product> getAllProducts(){
        
        try {
            String sql = "select * from productos";
            Connection connection = adapter.getConnection();
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            
            while(results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                double price = results.getDouble(3);
                Product current = new Product(id, name, price);
                products.add(current);
            }
            return products;
            
            
        } catch (Exception e){
            e.printStackTrace();
            return null;
            
        }
    }
}
