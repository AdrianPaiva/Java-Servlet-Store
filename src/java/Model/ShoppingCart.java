/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 1
CRN - 13099
 */

package Model;

import Controller.index;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class ShoppingCart {
    
    
    public ShoppingCart() {
        
    }
    public ArrayList<ShoppingCartProduct> getProductsInCart(int userId)
    {
        DatabaseConnection dc = new DatabaseConnection();
         ArrayList<ShoppingCartProduct> cartProducts = new ArrayList<>();
         ShoppingCartProduct scp ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "SELECT * FROM shoppingCart INNER JOIN products ON shoppingCart.productId=products.id";
                
                Statement st = con.createStatement();
                
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next())
                {
                    if(rs.getInt("userId") == userId)
                    {
                        scp = new ShoppingCartProduct();
                        scp.setId(rs.getInt("id"));
                        scp.setQuantity(rs.getInt("quantity"));
                        scp.setProductId(rs.getInt("productId"));
                        scp.setUserId(rs.getInt("userId"));
                        scp.setName(rs.getString("name"));
                        scp.setDescription(rs.getString("description"));
                        scp.setPrice(rs.getDouble("price"));
                        scp.setImage(rs.getString("image"));
                        scp.setCategory(rs.getInt("category"));
                    
                        scp.setQuantityInStock(rs.getInt("quantityInStock"));
                    
                        cartProducts.add(scp);
                    }
                    
                }
                st.close();
 
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return cartProducts;
        
    }
    public void addItemToCart(int userId, int productId)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "INSERT INTO shoppingCart(quantity,productId,userId)" +
                                "VALUES(?, ?, ?)";
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setInt(1, 1);
                prep.setInt(2, productId);
                prep.setInt(3, userId);
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    public void incrementProdQuantity(int userId, int productId)
    {
        for (ShoppingCartProduct scp : getProductsInCart(userId)) {
            if(scp.getUserId() == userId && scp.getProductId() == productId)
            {
                int quantity = scp.getQuantity() + 1;
                Catalog c = new Catalog();
                
                if(quantity <= c.getProductQuantityInStock(productId))
                {
                    DatabaseConnection dc = new DatabaseConnection();
            
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                        String query = "UPDATE shoppingCart SET quantity=? WHERE userId=? AND productId=?" ;
                                                   
                        PreparedStatement prep = con.prepareStatement(query);
                        prep.setInt(1, quantity);
                        prep.setInt(2, userId);
                        prep.setInt(3, productId);
                
                        prep.execute();
                
                        con.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    public void decrementProdQuantity(int userId, int productId)
    {
        for (ShoppingCartProduct scp : getProductsInCart(userId)) {
            if(scp.getUserId() == userId && scp.getProductId() == productId)
            {
                int quantity = scp.getQuantity() - 1;
                Catalog c = new Catalog();
                
                if(quantity >= 1)
                {
                    DatabaseConnection dc = new DatabaseConnection();
            
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                        String query = "UPDATE shoppingCart SET quantity=? WHERE userId=? AND productId=?" ;
                                                   
                        PreparedStatement prep = con.prepareStatement(query);
                        prep.setInt(1, quantity);
                        prep.setInt(2, userId);
                        prep.setInt(3, productId);
                
                        prep.execute();
                
                        con.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else 
                {
                    //
                }
            }
        }
    }
    public void removeItemFromCart(int userId, int productId)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                        String query = "DELETE FROM shoppingCart WHERE productId = ? AND userId = ? " ;
                                                   
                        PreparedStatement prep = con.prepareStatement(query);
                        
                        prep.setInt(1, productId);
                        prep.setInt(2, userId);
                
                        prep.execute();
                
                        con.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    public boolean cartHasProduct(int userId, int productId)
    {
        for (ShoppingCartProduct scp : getProductsInCart(userId)) {
            if(scp.getUserId() == userId && scp.getProductId() == productId)
            {
                return true;
            }
        }
        return false;
    }
    public double getTotalCost(int userId)
    {
        double total = 0;
        for (ShoppingCartProduct scp : getProductsInCart(userId)) {
            total += scp.getProductQuantityPrice();
        }
        return total;
    }
    public double getTotalCostWithShipping(int userId)
    {
        double total = getTotalCost(userId) + getShippingCost(userId);
        
        return total;
    }
    public double getShippingCost(int userId)
    {
        double total = (getTotalCost(userId) * 0.05);
        
        return total;
    }
    public double getTaxCost(int userId)
    {
        double total = (getTotalCostWithShipping(userId) * 0.13);
        
        return total;
    }
    public double getTotalCostAfterTaxes(int userId)
    {
        double total = ( getTotalCostWithShipping(userId) + getTaxCost(userId));
        
        return total;
    }
    
    
    
}
