/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Catalog;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class editProduct extends HttpServlet {

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
            
            String name = null;
            String description = null;
            String price = null;
            String quantity = null;
            String category = null;
            String image = null;
            
            String prodId = null;
            int productId = 0;          
            int quantityInt = 0;
            double priceDouble = 0;
            int categoryInt = 0;
            
            HttpSession session = request.getSession();
            
            if(request.getParameterMap().containsKey("InputName"))
            {
               name = request.getParameter("InputName");
                description = request.getParameter("InputDescription");
                price = request.getParameter("InputPrice");
                 quantity = request.getParameter("InputQuantity");
                category = request.getParameter("InputCategory");
            
                prodId = (String)session.getAttribute("editId");
           
           
                
                try
                {
                    quantityInt = Integer.parseInt(quantity);
                    priceDouble = Double.parseDouble(price);
                    categoryInt = Integer.parseInt(category);
                    productId = Integer.parseInt(prodId);
       
                }
                catch(NumberFormatException e)
                {
               
                    request.setAttribute("errorMsg", "invalid input!");
                 }
            
                    Catalog catalog = new Catalog();
                    catalog.editProduct(productId,name, description, priceDouble, quantityInt, categoryInt, "images/bass3.jpg"); 
                    request.setAttribute("errorMsg", "Success!"); 
                
                
            }
            if(request.getParameterMap().containsKey("editId"))
            {
                String editId = request.getParameter("editId");
                session.setAttribute("editId", editId);
            }
            
            
             
  
            
            
            RequestDispatcher view = request.getRequestDispatcher("editProduct.jsp");
            view.forward(request,response);
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
