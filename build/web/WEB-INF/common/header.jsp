

<div class="container">
    <a class="navbar-brand" href="controller">Home<img border="0" src="images/logo.gif"/></a>

    <form action="controller?section=searchitems">
        <input type="text" name="keyword">
        <input type="submit" value="Search">
    </form>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>




    <c:out   value="${sessionScope.Welcome}"/>                    
    <c:choose>
        <c:when test="${empty sessionScope.Welcome}">
            <div  class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li  class="nav-item active">
                        <a class="nav-link"  href="controller?section=login&signOn=true">Sign on
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <div  class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li  class="nav-item active">
                        <a class="nav-link"  href="controller?section=customer&afficheCustomer">Account
                            <span class="sr-only">(current)</span>               
                        </a> |
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="controller?section=panier&affichePanier">Cart</a> |
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='controller?section=login&deconnect'>Sign off</a>
                    </li>
                </ul>
            </div>
        </c:otherwise>
    </c:choose> 

</div>