<%-- 
    Document   : editProduct
    Created on : Nov 27, 2014, 6:26:31 PM
    Author     : adrian
--%>

<%@page import="Model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Categories"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit product</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <%@include file='/includes/header.jsp'%>
            
           <div class="content">
                   <%
               Categories ca = new Categories();
               ArrayList<Category> cate = ca.getCategories();

               
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
               <form action="editProduct" method="POST"   role="form">
                
                
                
              <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputName">Product Name:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Enter Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputDescription">Description:</label>
                    <div class="input-group">
                        <textarea class="form-control" name="InputDescription" rows="5" id="inputDescription" required></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputPrice">Price:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputPrice" name="InputPrice" placeholder="Enter Price" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputQuantity">Quantity:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputQuantity" name="InputQuantity" placeholder="Enter Quantity" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="InputCategory">Category:</label>
                    <div class="input-group">
                        <select class="form-control" name="InputCategory" id="InputCategory">
                            <%
                                for(Category c:cate)
                                {%>
                                    <option value="<%=c.getId()%>"><%=c.getCategoryName()%></option>
                               <% }%>
                            
                            
                            
    
                        </select>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
               <!--<h6>Image: </h6><input type="file" name="file" id="file" required>-->
                
                
                <br>
                
                <input type="submit" value="Edit Product" class="btn btn-info">
                </form>
               ${errorMsg}
            </div>
              
              
              
           </div>
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>
