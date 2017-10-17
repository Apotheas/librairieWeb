

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    
     <jsp:useBean id="bPanier" class="com.cdi.g3.web.beans.beanPanier" scope="session" />
    <a class="navbar-brand" href="controller?home=true">Home<img border="0" src="images/logo.gif"/></a>

    <form action="controller?section=searchitems">
        <input type="text" name="keyword">
        <input type="submit" value="Search">
    </form>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

   
    
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
                        <a class="nav-link"  href="controller?section=panier&affichePanier"> <span style="font-size: 20px;" class="glyphicon glyphicon-shopping-cart"></span> <span class="badge">  ${sessionScope.size}</span>   Mon Panier</a>
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
                        <a class="nav-link"  href="controller?section=panier&affichePanier"> <span style="font-size: 20px;" class="glyphicon glyphicon-shopping-cart"><span class="badge">  ${sessionScope.size}</span>  Mon Panier</a>
                    </li>
                </ul>
            </div>
     </c:if>    
    <%--
       
    <c:out   value="${sessionScope.Welcome}"/>                    
    <c:choose>
        <c:when test="${empty sessionScope.Welcome}">
            <div  class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li  class="nav-item active">
                        <a class="nav-link"  href="controller?section=login&signOn=true">Me Connecter
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="controller?section=customer&addCustomer">Ajouter un compte</a> |
                    </li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <div  class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li  class="nav-item active">
                        <a class="nav-link"  href="controller?section=customer&afficheCustomer">Mon compte
                            <span class="sr-only">(current)</span>               
                        </a> |
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="controller?section=panier&affichePanier"> <img src="images/cart.png" alt=""> ${sessionScope.size}  Mon Panier</a> |
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='controller?section=login&deconnect'>Se Deconnecter</a>
                    </li>
                </ul>
            </div>
        </c:otherwise>
    </c:choose>
        
    --%>

</div>