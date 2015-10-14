/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */

package Controller;

import Model.User;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            String username = null;
            String password = null;
            String email = null;
            
            String firstName = null;
            String lastName = null;
            String address = null;
            
            Users u = new Users();
            boolean nameTaken = false; 
            
            if(request.getParameterMap().containsKey("InputName") && request.getParameterMap().containsKey("InputPassword") && request.getParameterMap().containsKey("InputEmail"))
            {
                username = request.getParameter("InputName");
                password = request.getParameter("InputPassword");
                email = request.getParameter("InputEmail");
                
                firstName = request.getParameter("InputFirstName");
                lastName = request.getParameter("InputLastName");
                address = request.getParameter("InputAddress");
                
                for (User user : u.getUsers()) {
                    if(user.getUsername().equals(username))
                    {
                        nameTaken = true;
                        
                        request.setAttribute("errorMsg", "This username is currently taken!");
                        RequestDispatcher view = request.getRequestDispatcher("register.jsp");
                        view.forward(request, response);
                        
                    }
                    if(user.getEmail().equals(email))
                    {
                        nameTaken = true;
                        
                        request.setAttribute("errorMsg", "This email is already registered to an account!");
                        RequestDispatcher view = request.getRequestDispatcher("register.jsp");
                        view.forward(request, response);
                    }
                }
                
                if(!nameTaken)
                {
                     u.registerUser(username, password, email,firstName,lastName,address);
                     
                     RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                     view.forward(request, response);
                }
                
                
            
            }
            
           
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
