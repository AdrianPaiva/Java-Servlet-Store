<%-- 
    Document   : admin
    Created on : Nov 26, 2014, 6:16:07 PM
    Author     : adrian
--%>

<%@page import="Model.Users"%>
<%@page import="Model.User"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <%@include file='/includes/header.jsp'%>
            
           <div class="content">
               <%
               
                if(ses.getAttribute("user") == null)
                {
                    response.sendRedirect("index.jsp");
                }
                else
                {
                    User usss = (User)ses.getAttribute("user");
            
                Users userss = new Users();
                if (!userss.isAdmin(usss.getId())) {
                    response.sendRedirect("index.jsp");
                }
                }
                
                       
               %>
               <div class='row'>
                         
                        <div class='col-md-3'>
                            <div class='list-group'>                               
                                    <a href='admin?addProduct=true' class="list-group-item">Add Product</a> 
                                    <a href='admin?addCategory=true' class="list-group-item">Add Category</a>  
                                    <a href='admin?viewAll=true' class="list-group-item">View All</a>
                            </div>
                        </div>
                        
                   <c:forEach var="cat" items="${catalog}">
                       <div class='col-sm-2'>  
                            <div class='thumbnail'>                               
                             <img class="img" src='${cat.image}' alt=''>
                                <div class='caption'>
                                    <h4 class='pull-right'>$ ${cat.price}</h4>
                                    <h3>${cat.name}</h3>
                                    <h5>${cat.description}</h5>
                                    <h3>${cat.quantityInStock} In Stock</h3>
                                    
                                    <a href="editProduct?editId=${cat.id}" class='btn btn-warning btn-sm'>Edit</a> 
                                    <a href="deleteProduct?deleteId=${cat.id}" class='btn btn-danger btn-sm'>Delete</a> 
                                </div>

                            </div>
                          </div>
                   </c:forEach>
                         
               </div>
              
              
           </div>
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>
