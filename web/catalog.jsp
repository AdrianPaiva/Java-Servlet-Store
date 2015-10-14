<%-- 
    Document   : catalog
    Created on : Sep 26, 2014, 2:31:05 PM
    Author     : adrian
--%>

<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalog</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <%@include file='/includes/header.jsp'%>
            
           <div class="content">
              
               <%
 
                   if(session.getAttribute("user") == null)
                   {
                       
                       response.sendRedirect("index");
                   }
               
                %>      
                     
                     <div class='row'>
                         
                        <div class='col-md-3'>
                            <div class='list-group'>
                                <c:forEach var="cat" items="${listOfCategories}">
                                    <a href='catalog?category=${cat.id}' class="list-group-item">${cat.categoryName}</a>                                  
                                </c:forEach>
                            </div>
                        </div>
                       
                           
                            
                                
                         <%
                            ArrayList<Product> catalog = (ArrayList<Product>)request.getAttribute("catalog");
                            
                      for (Product prod : catalog) 
                        {%>
                          
                            <div class='col-sm-2'>  
                            <div class='thumbnail'>                               
                             <img class="img" src='<%= prod.getImage() %>' alt=''>
                                <div class='caption'>
                                    <h4 class='pull-right'>$<%= prod.getPrice()%></h4>
                                    <h3><%= prod.getName()%></h3>
                                    <h5><%= prod.getDescription()%></h5>
                                    
                                    <a href="shoppingCart?prodId=<%= prod.getId() %>" class='btn btn-info btn-sm'>Add to Cart</a> 
                                </div>

                            </div>
                            </div>
                     
                     
                        <%    
                           }
                        %>
                     </div>                     
                                
                               
                 
                
            
                
                
                
                
           </div><!--content-->
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>
