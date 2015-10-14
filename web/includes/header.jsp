 <%@page import="Model.Users"%>
<%@page import="Model.User"%>
<div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index">KABOOM MUSIC!</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="index">Home</a></li>
              <%
                  if(session.getAttribute("user") != null)
                  {
                      out.println("<li><a href='catalog'>Catalog</a></li>");
                  }   
               %>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%
                  HttpSession ses = request.getSession();  
                  if(ses.getAttribute("user") != null)
                  {
                      User uTT = (User)ses.getAttribute("user");
            
                    Users usersTT = new Users();
                    
                    if (usersTT.isAdmin(uTT.getId())) 
                    {
                        out.println("<li><a href='admin?viewAll=true'>Admin</a></li>");
                    }
                      
                  }
                    
                  if(session.getAttribute("user") == null)
                  {
                      out.println("<li><a href='login.jsp'>Login</a></li>");
                      out.println("<li><a href='register.jsp'>Register</a></li>");
                  }
                  else if(session.getAttribute("user") != null)
                  {
                      out.println("<li><a href='logout'>Logout</a></li>");
                      out.println("<li><a href='shoppingCart'>Cart</a></li>");
                  }
               %>
              
              
              
              
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>
        
      

      
