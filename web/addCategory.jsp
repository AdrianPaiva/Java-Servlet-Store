<%-- 
    Document   : addCategory
    Created on : Nov 26, 2014, 10:58:24 PM
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
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
        <form method="post" action="addCategory" role="form">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="categoryName">Category Name:</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="categoryName" id="categoryName" placeholder="Enter Category Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
                
        </form>
              
              
           </div>
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>
