/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Catalog;
import Model.Categories;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */
public class addProduct extends HttpServlet {

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
        
        int quantityInt = 0;
        double priceDouble = 0;
        int categoryInt = 0;
        
        
            /*
            List<FileItem> items = null;
             ServletContext servletContext = request.getSession().getServletContext();
        
        String path = servletContext.getRealPath("/images") + File.separator;
            try 
            {
                items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                
            } catch (FileUploadException e) 
            {
                throw new ServletException("Cannot parse multipart request.", e);
            }
            for (FileItem item : items) 
            {
                if (item.isFormField()) 
                {
                // Process regular form fields here the same way as request.getParameter().
                // You can get parameter name by item.getFieldName();
                // You can get parameter value by item.getString();
                    
                   name = item.getString("InputName");
                    description = item.getString("InputDescription");
                    price = item.getString("InputPrice");
                    quantity = item.getString("InputQuantity");
                    category = item.getString("InputCategory");
                   
                    
                } 
                else 
                {
                // Process uploaded fields here.
                    String filename = FilenameUtils.getName(item.getName()); // Get filename.
                    File file = new File(path, filename); // Define destination file.
                    
                    image = "images/" + filename;
                    
                    
                    try 
                    {
                        item.write(file); // Write to destination file.
                    } catch (Exception ex) 
                    {
                        Logger.getLogger(addProduct.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                 */
              
            name = request.getParameter("InputName");
            description = request.getParameter("InputDescription");
            price = request.getParameter("InputPrice");
            quantity = request.getParameter("InputQuantity");
            category = request.getParameter("InputCategory");
           
           
                
            try
            {
                quantityInt = Integer.parseInt(quantity);
                priceDouble = Double.parseDouble(price);
                categoryInt = Integer.parseInt(category);

                
                
            }
            catch(NumberFormatException e)
            {
               
                request.setAttribute("errorMsg", "invalid input!");
            }
             Catalog catalog = new Catalog();
             catalog.addProduct(name, description, priceDouble, quantityInt, categoryInt, "images/bass3.jpg");
  
            
            
            RequestDispatcher view = request.getRequestDispatcher("addProduct.jsp");
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
