<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            

                <div class="col-lg-12" >
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#">WebSiteName</a>
                            </div>
                            
                            <a href="<%= request.getContextPath() %>/index.jsp"><img border="0" src="images/logo.gif"/></a>
                            
                             <form action="<%= request.getContextPath() %>/searchitems">
                                <input type="text" name="keyword">
                                <input type="submit" value="Search">
                            </form>
                                
                                <br>
                                
            
            <c:out   value="${sessionScope.Welcome}"/>                    
         <c:choose>
                <c:when test="${empty sessionScope.Welcome}">
                    <a href="controller?section=login&signOn=true">Sign on</a>
                </c:when>
                <c:otherwise>
            		<a href="controller?section=customer&afficheCustomer">Account</a> |
            		<a href="controller?section=panier&affichePanier">Cart</a> |
                    <a href='controller?section=login&deconnect'>Sign off</a>
                </c:otherwise>
            </c:choose>  
                        </div>
                    </nav>
                                

                </div>
          

