<%-- 
    Document   : checkout
    Created on : Oct 12, 2014, 5:47:32 PM
    Author     : adrian
--%>

<%@page import="Model.Product"%>
<%@page import="Model.ShoppingCart"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        
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
               <h4>Please Review Your Order </h4>
               
               <div class="content">
              <div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5>Order Summary</h5>
							</div>
							
						</div>
					</div>
				</div>
				<div class="panel-body">
                                    <c:forEach var="prod" items="${productSummary}">
                                           <div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="${prod.image}">
						</div>
						<div class="col-xs-4">
                                                    <h4 class="product-name"><strong>${prod.name}</strong></h4><h4><small>${prod.description}</small></h4>
						</div>
						<div class="col-xs-6">
							<div class="col-xs-6 text-right ">
								<h6><strong>${prod.quantity}<span class="text-muted">x</span></strong></h6>
							</div>
                                                        <div class="col-xs-2 text-right">
								<h6><strong>$${prod.price}<span class="text-muted"></span></strong></h6>
							</div>
							
                                                        <div class="col-xs-9">
								<h6 class="text-right">= $ ${prod.getProductQuantityPrice()}</h6>
							</div>
						</div>
					</div>                       
                                     </c:forEach>                                       
					
                                        <hr>
                                                              
					
					<div class="row">
						<div class="text-center">
							<div class="col-xs-9">
								<h6 class="text-right">Product total:  $ ${totalCost} </h6>
                                                                <h6 class="text-right">Taxes: $ ${taxCost}</h6>
                                                                <h6 class="text-right">Shipping: $ ${shippingCost}</h6>
							</div>
							<div class="col-xs-3">
								
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row text-center">
						<div class="col-xs-9">
							<h4 class="text-right">Subtotal <strong>$ ${subTotal} </strong></h4>
						</div>
						
					</div>
				</div>
			</div>
                                                <a href="completeOrder" class='btn btn-warning btn-sm'>Click Here to Complete Your Order</a> 
		</div>
              
              
              
           </div>
              
              
              
           </div>
       
         <%@include file='/includes/footer.jsp'%>
        </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    </body>
</html>
