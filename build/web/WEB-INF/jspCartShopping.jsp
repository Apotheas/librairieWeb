<%@page import="com.cdi.g3.server.domain.catalog.Book"%>
<%@page import="com.cdi.g3.web.beans.beanCatalog"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home</title> 
        <!-- Bootstrap core CSS -->        
        <link href="css/librairie/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>  
        <!-- Custom styles for this template -->       
        <link href="css/shop-homepage.css" rel="stylesheet"/>

        <!--  <link href="css/bootstrap/css/bootstrap.css"  rel="stylesheet" /> -->
        <!--<link rel="stylesheet" href="css/form.css" />-->



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>


    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <jsp:include page="common/header.jsp"/>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-lg-3">
                    <jsp:include page="common/navigation.jsp"/>
                </div>
                <!-- /.col-lg-3 -->
                <div class="col-sm-9">

                <!-- Partie de Content a changer par rapport au besoin -->
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
                
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

                
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
                <!--Fin de la partie de Content a changer par rapport au besoin -->
                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <jsp:include page="common/footer.jsp"/>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper/popper.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    </body>

</html>
