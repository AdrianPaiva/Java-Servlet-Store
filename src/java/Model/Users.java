/*
Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 1
CRN - 13099
 */

package Model;

import Controller.index;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class Users {
     
    
    public Users()
    {
       
           
    }
    public ArrayList<User> getUsers()
    {
         DatabaseConnection dc = new DatabaseConnection();
         ArrayList<User> users = new ArrayList<>();
         User u ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "SELECT * FROM users";
                
                Statement st = con.createStatement();
                
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next())
                {
                    u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setEmail(rs.getString("email"));
                    u.setAdmin(rs.getInt("admin"));
                    
                    users.add(u);
                }
                st.close();
 
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        return users;
    }
      
    public void registerUser(String username, String password, String email, String firstName, String lastName, String address)
    {
            DatabaseConnection dc = new DatabaseConnection();
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(dc.getUrl(), dc.getUsername(), dc.getPassword());
                
                String query = "INSERT INTO users(username,password,email,admin,firstName,lastName,address)" +
                                "VALUES(?, ?, ?,?,?,?,?)";
                
                PreparedStatement prep = con.prepareStatement(query);
                prep.setString(1, username);
                prep.setString(2, password);
                prep.setString(3, email);
                prep.setInt(4, 0);
                
                prep.setString(5, firstName);
                prep.setString(6, lastName);
                prep.setString(7, address);
                
                prep.execute();
                
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public boolean isAdmin(int userId)
    {
        for (User u : getUsers()) {
            if(u.getId() == userId && u.getAdmin() == 1)
            {
                return true;
            }
        }
        return false;
    }
}
