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
        <link href="css/vendor/bootstrap/css/bootstrap.css"  rel="stylesheet" />       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Custom styles for this template -->       
        <link href="css/shop-homepage.css" rel="stylesheet"/>
        <!--<link rel="stylesheet" href="css/form.css" />-->
    </head>


    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="relou">
            <jsp:include page="common/header.jsp"/>
        </nav>


        <!-- Partie de Content a changer par rapport au besoin -->
        <!----------------------------------------------------------------->       
        <!------------------------------------------------------------------->
        <!-------------------------------------------------------------------->




        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <h2>Table</h2>
                <p>The cart shopping:</p>                        

                <c:if test="${panierVide}">
                    Panier vide.    
                </c:if>
                    
                <c:if test="${!panierVide}">
                    
                    <div class="col-sm-12 col-md-10 col-md-offset-1">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="i" items="${panier}">

                                    <tr>
                                        <td class="col-sm-8 col-md-6">
                                            <div class="media">
                                                <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${i.book.pathIconBook}" style="width: 72px; height: 72px;"> </a>
                                                <div class="media-body">
                                                    <h4 class="media-heading"><a href="#">${i.book.titleBook}</a></h4>
                                                    <h5 class="media-heading"> ISBN : <a href="#">${i.book.numISBNBook}</a></h5>
                                                    <span>Status: </span><span class="text-success"><strong>${i.book.stockBook} In Stock</strong></span>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="col-sm-1 col-md-1" style="text-align: center">
                                            <a href="controller?section=panier&affichePanier=true&add=${i.ref}">+</a>  
                                            <input type="email" class="form-control" id="exampleInputEmail1" value="${i.quantity}">
                                            <a href="controller?section=panier&affichePanier=true&dec=${i.ref}">-</a>

                                        </td>
                                        <td class="col-sm-1 col-md-1 text-center"><strong>€ ${i.book.unitCostBook}</strong></td>
                                        
                                        <td class="col-sm-1 col-md-1 text-center"><strong>€ ${i.totalLine}</strong></td>

                                        <td class="col-sm-1 col-md-1">
                                            <a href="controller?section=panier&affichePanier=true&del=${i.ref}">
                                                <button type="button" class="btn btn-danger">                            
                                                    <span class="glyphicon glyphicon-remove"></span>  Remove
                                                </button>
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                    <td><h5>Subtotal</h5></td>
                                    <td class="text-right"><h5><strong>€ ${subTotalHT}</strong></h5></td>
                                </tr>
                                <tr>
                                    
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                   
                                    <td><h5>Estimated shipping</h5></td>
                                    <td class="text-right"><h5><strong>€6.94</strong></h5></td>
                                </tr>
                                <tr>
                                    
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                    <td><h3>Total</h3></td>
                                    <td class="text-right"><h3><strong>$31.53</strong></h3></td>
                                </tr>
                                
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                    <td>
                                        <a href="controller">
                                        <button type="button" class="btn btn-default">
                                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                                        </button>
                                             </a> 
                                        </td>
                                    <td>
                                         <a href="controller?section=order&checkOut=true">
                                        <button type="button" class="btn btn-success">
                                            Checkout <span class="glyphicon glyphicon-play"></span>
                                        </button>
                                             </a> 
                                         </td>
                                </tr>
                            </tbody>
                        </table>
                        <a href="controller?section=panier&clear">
                                        <button type="button" class="btn btn-default">
                                            <span class="glyphicon glyphicon-shopping-cart"></span> Vider le panier !
                                        </button>
                                        </a> 
                        
                    </div>

                                  
                </c:if>                   

            </div>

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
