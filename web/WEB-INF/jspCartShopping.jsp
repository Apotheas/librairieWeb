<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Cart Shopping</title>        
        <link type="text/css" rel="stylesheet" href="css/bootstrap/css/bootstrap.css" />
        <link type="text/css" rel="stylesheet" href="css/form.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>


    <body>
        <div class="container">
            <header class="row" id="header">
                <jsp:include page="common/header.jsp"/>
            </header>

            <div class="row">                

                <nav  class="col-lg-3" id="navBar">
                    <jsp:include page="common/navigation.jsp"/>
                </nav> 

                <section class="col-lg-9">

                    <div class="row">
                        <div class="col-sm-9">
                            <h2>Table</h2>
                            <p>The cart shopping:</p>                        

                            <c:if test="${panierVide}">
                                Panier vide.    
                            </c:if>
                            <c:if test="${!panierVide}">



                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Ref</th>
                                            <th>Quantity</th>
                                            <th>Ajouter</th>
                                            <th>Enlever</th>
                                            <th>Supprimer</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        
                                        
                                        
                                        <c:forEach var="i" items="${panier}">
                                            <tr>
                                                <td> ${i.ref}</td>
                                                <td> ${i.quantity}</td>
                                                <td><a href="controller?section=panier&affichePanier=true&add=${i.ref}">+</a></td>
                                                <td> <a href="controller?section=panier&affichePanier=true&dec=${i.ref}">-</a></td>
                                                <td> <a href="controller?section=panier&affichePanier=true&del=${i.ref}">X</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 

                                <br>

                                <a href="controller?section=panier&clear">Vider le panier !</a>

                            </c:if>      

                        </div>
                    </div>

                </section>
            </div>


            <footer class="row" id="footer">
                <jsp:include page="common/footer.jsp"/>
            </footer>
        </div>
    </body>
</html>

























