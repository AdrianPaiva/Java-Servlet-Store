/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Categories {

    public Categories()
    {

    }
    public ArrayList<Category> getCategories()
    {
        DatabaseConnection dc = new DatabaseConnection();
         ArrayList<Category> cat = new ArrayList<>();
         Category c ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());

                String query = "SELECT * FROM categories";

                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(query);

                while (rs.next())
                {
                    c = new Category();
                    c.setId(rs.getInt("id"));
                    c.setCategoryName(rs.getString("categoryName"));

                    cat.add(c);
                }
                st.close();

                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }

        return cat;
    }
    public void addCategory(String categoryName)
    {
        DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "INSERT INTO categories(categoryName)" +
                                "VALUES(?)";
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setString(1, categoryName);
                
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
