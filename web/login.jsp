<%-- 
    Document   : login
    Created on : Sep 25, 2014, 9:18:58 PM
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <%@include file='/includes/header.jsp'%>
            
           <div class="content">
               
               
               <form method="post" class="form-signin" role="form" action="loginValidate">
                   <h2 class="form-signin-heading">Please sign in</h2>
                   <br>
                    <input type="username" name="username" class="form-control" placeholder="Username" required autofocus>
                    <input type="password" name="password" class="form-control" placeholder="Password" required>
                    
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
               ${errorMsg}
               
           </div>
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>

