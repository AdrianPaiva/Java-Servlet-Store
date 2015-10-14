/*
 Adrian Paiva 100864588
Patrick Gomes Sanches

Comp 3095 - Assignment 2
CRN - 13099
 */

package Controller;

import Model.ShoppingCart;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adrian
 */
public class shoppingCart extends HttpServlet {

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
            
            HttpSession session = request.getSession();           
            
            String prodId = null;
            String deleteId = null;
            String incrementId = null;
            String decrementId = null;
            
            User u = (User)session.getAttribute("user");
            
            ShoppingCart sc = new ShoppingCart();
            
            
            if (request.getParameterMap().containsKey("prodId")) {
                    
                    prodId = request.getParameter("prodId");  
                    int p = Integer.parseInt(prodId);
                    
                    if(prodId != null)
                    {
                        if(sc.cartHasProduct(u.getId(), p))
                        {
                            sc.incrementProdQuantity(u.getId(),p );
                        }
                        else
                        {
                            sc.addItemToCart(u.getId(), p);
                        }
                        
                    }                     
                } 
            
            if (request.getParameterMap().containsKey("incrementId")) {
                    incrementId = request.getParameter("incrementId"); 
                    int i = Integer.parseInt(incrementId);
                    if(incrementId != null)
                    {
                        sc.incrementProdQuantity(u.getId(),i );
                    }                     
                }
            if (request.getParameterMap().containsKey("decrementId")) {
                    decrementId = request.getParameter("decrementId"); 
                    
                    int d = Integer.parseInt(decrementId);
                    
                    if(decrementId != null)
                    {
                        sc.decrementProdQuantity(u.getId(), d);
                    }                     
                }
            if (request.getParameterMap().containsKey("deleteId")) {
                
                    deleteId = request.getParameter("deleteId"); 
                    int d = Integer.parseInt(deleteId);
                    if(deleteId != null)
                    {
                       sc.removeItemFromCart(u.getId(), d);
                    }                     
                }
            
            
               request.setAttribute("totalCost",sc.getTotalCost(u.getId()));
               request.setAttribute("cartItems", sc.getProductsInCart(u.getId())); 
            
            RequestDispatcher view = request.getRequestDispatcher("shoppingCart.jsp");
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
