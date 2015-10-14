/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 1
CRN - 13099
 */

package Controller;

import Model.Catalog;
import Model.Categories;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
public class catalog extends HttpServlet {

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
            
            Catalog c = new Catalog();
            ArrayList<Product> catalog = new ArrayList<>();
            
            Categories cc = new Categories(); // categories db model
            
            
            String category = null;
            if (request.getParameterMap().containsKey("category")) {
                category = request.getParameter("category");
                
                int cat = Integer.parseInt(category);
                
                for (Product product : c.getCatalog()) {
                if(product.getCategory() == cat)
                {
                    catalog.add(product);
                }  
        }
            
            
               
                
            }
            if(category == null)
            {
                request.setAttribute("catalog", c.getCatalog());// get all items if no cat selected
            }
            else
            {
                request.setAttribute("catalog", catalog);
            }
            
            
            request.setAttribute("category", category); // category that user selected
            
            request.setAttribute("listOfCategories",cc.getCategories() ); //list of all category objects from db
            
            RequestDispatcher view = request.getRequestDispatcher("catalog.jsp");
            view.forward(request, response);
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
