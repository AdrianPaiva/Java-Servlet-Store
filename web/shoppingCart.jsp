
<%@page import="Model.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
         <%@include file='/includes/header.jsp'%>
            <%
 
                   if(session.getAttribute("user") == null)
                   {
                       
                       response.sendRedirect("index");
                   }
         
                %>  
           <div class="content">
              <div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
							</div>
							<div class="col-xs-6">
								<a href="catalog" class="btn btn-primary btn-sm btn-block">
									<span class="glyphicon glyphicon-share-alt"></span> Continue shopping
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
                                    <c:forEach var="prod" items="${cartItems}">
                                        
                                    
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="${prod.image}">
						</div>
						<div class="col-xs-4">
                                                    <h4 class="product-name"><strong>${prod.name}</strong></h4><h4><small>${prod.description}</small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6><strong><span class="text-muted">${prod.quantity}x</span></strong></h6>
							</div>
							<div class="col-xs-2">
								<a href="shoppingCart?incrementId=${prod.productId}" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-upload"></span></a>
							</div>
                                                        
							<div class="col-xs-2">
                                                                <a href="shoppingCart?decrementId=${prod.productId}" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-download"></span></a>
                                                             
							</div>
                                                        <div class="col-xs-2">  
                                                              <a href="shoppingCart?deleteId=${prod.productId}" class="btn btn-link btn-xs">
									<span class="glyphicon glyphicon-trash"> </span>
								</a>
                                                        </div>
                                                        <div class="col-xs-9">
                                                                <h6 class="text-right">$${prod.price} X ${prod.quantity}</h6>
								<h6 class="text-right">= $${prod.getProductQuantityPrice()}</h6>
							</div>
						</div>
					</div>
                                        <hr>
                                         </c:forEach>                        
					
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right"></h6>
							</div>
							<div class="col-xs-3">
								
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Total <strong>$ ${totalCost}</strong></h4>
						</div>
						<div class="col-xs-3">
							<a href="checkout?checkout=true" class="btn btn-success btn-block">
								Checkout
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
              
              
              
           </div>
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>

