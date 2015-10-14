/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class DatabaseConnection {
    private String url;
    private String username;
    private String password;
    
    public DatabaseConnection()
    {
        url = "jdbc:mysql://localhost:3306/learning";
        username = "root";
        password = "";
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
