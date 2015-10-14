/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */

package Model;

import Controller.index;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class Catalog {
    
   
    
    public Catalog()
    {
        /*
        if(catalog.isEmpty())
        {
            catalog.add(new Product(1,"Fender Stratocaster","Brand new 2014 American special model",799.99,"images/strat.jpg","guitars"));
            catalog.add(new Product(2,"Gibson Les Paul","Brand new 2014 Traditional model",2299.99,"images/lespaul.jpg","guitars"));
            catalog.add(new Product(3,"Gretsch Duo Jet","Brand new 2015 George Harrison model",599.99,"images/gretsch.jpg","guitars"));
            
            catalog.add(new Product(4,"Fender Pawn Shop Bass","Limited Edition 2014 American model",599.99,"images/bass1.png","basses"));
            catalog.add(new Product(5,"Fender Jazz Bass","Brand new 2014 Traditional model",1299.99,"images/bass2.jpg","basses"));
            catalog.add(new Product(6,"Gretsch Bass","Brand new 2015 George Harrison model",599.99,"images/bass3.jpg","basses"));
            
            catalog.add(new Product(7,"DDrum Drum Kit","Limited Edition 2014 Advanced model",1599.99,"images/drums1.jpg","drums"));
            catalog.add(new Product(8,"Ford Drum Kit","Brand new 2014 beginner model",1499.99,"images/drums2.jpg","drums"));
            catalog.add(new Product(9,"GMS Drum kit","Brand new 2015 intermediate model",699.99,"images/drums3.jpg","drums"));
        }
                */
    }
    public ArrayList<Product> getCatalog()
    {
          DatabaseConnection dc = new DatabaseConnection();
         ArrayList<Product> catalog = new ArrayList<>();
         Product p ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "SELECT * FROM products";
                
                Statement st = con.createStatement();
                
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next())
                {
                    p = new Product();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setDescription(rs.getString("description"));
                    p.setPrice(rs.getDouble("price"));
                    p.setImage(rs.getString("image"));
                    p.setCategory(rs.getInt("category"));
                    
                    p.setQuantityInStock(rs.getInt("quantityInStock"));
                    
                    catalog.add(p);
                }
                st.close();
 
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return catalog;
    }
    public ArrayList<Product> getItemsInCategory(int category)
    {
        ArrayList<Product> categoryList = new ArrayList<>();
        
        for (Product product : getCatalog()) {
            if(product.getCategory() == category)
            {
                categoryList.add(product);
            }
        }
        return categoryList;
    }
    public int getProductQuantityInStock(int productId)
    {
        int stock = 0;
            for (Product p : getCatalog()) 
            {
                if (p.getId()== productId) {
                    stock = p.getQuantityInStock();
                }
            }
            return stock;
    }
    public void addProduct(String name,String description,Double price, int quantity,int category,String image)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "INSERT INTO products(name,description,price,image,category,quantityInStock)" +
                                "VALUES(?, ?, ?,?,?,?)";
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setString(1,name);
                prep.setString(2,description);
                prep.setDouble(3,price);
                prep.setString(4,image);
                prep.setInt(5,category);
                prep.setInt(6,quantity);
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void deleteProduct(int productId)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "DELETE FROM products WHERE id= ?";
                                
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setInt(1, productId);
                
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void editProduct(int productId,String name,String description,Double price, int quantity,int category,String image)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "UPDATE products SET name = ? , description = ? , price = ? , image = ? , category = ? , quantityInStock = ? " + 
                                " WHERE id = ? ";
                                
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setString(1,name);
                prep.setString(2,description);
                prep.setDouble(3,price);
                prep.setString(4,image);
                prep.setInt(5,category);
                prep.setInt(6,quantity);
                prep.setInt(7, productId);
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void updateStock(int productId, int quantity)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "UPDATE products SET quantityInStock = ? " + 
                                " WHERE id = ? ";
                                
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setInt(1,quantity);
                prep.setInt(2,productId);
                
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
