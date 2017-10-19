

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    
     <jsp:useBean id="bPanier" class="com.cdi.g3.web.beans.beanPanier" scope="session" />
     <div class="col-sm-3">
         <a class="navbar-brand" href="controller?home=true"><img width="90%" src="images/LogoHome.png"/></a>
     </div>
    <form  action="controller?section=searchitems">
        
        <input type="text" name="keyword">
       
        
         <input type="submit" action="controller?section=searchitems" value="Rechercher">
         
          
    </form>
    
   
    
    <c:if test="${empty sessionScope.Welcome}">
        <c:out   value="${sessionScope.Welcome}"/>    
        <div  class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li  class="nav-item active">
                        <a class="nav-link"  href="controller?section=login&signOn=true">Me Connecter |
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="controller?section=customer&addCustomer">Inscription  |</a> 
                    </li>
                    
                     <li class="nav-item">
                        <a class="nav-link"  href="controller?section=panier&affichePanier"> <img  src="images/cartTop.png" ><span class="badge">  ${sessionScope.size}</span>   Mon Panier</a>
                    </li>
                </ul>
            </div>
        
        </c:if>    
       <c:if test="${! empty sessionScope.Welcome}">
    <div  class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li  class="nav-item active">
                        <a class="nav-link"  href="controller?section=customer&afficheCustomer">Mon compte |
                            <span class="sr-only">(current)</span>               
                        </a> 
                    </li>
                   
                    <li class="nav-item">
                        <a class="nav-link" href='controller?section=login&deconnect'>Se Deconnecter |</a>
                    </li>
                    
                     <li class="nav-item">
                        <a class="nav-link"  href="controller?section=panier&affichePanier"> <img  src="images/cartTop.png" ><span class="badge">  ${sessionScope.size}</span>  Mon Panier</a>
                    </li>
                </ul>
            </div>
     </c:if>    
    

</div>