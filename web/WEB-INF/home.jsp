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
        
        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        
        <!-- Custom styles for this template -->       
        <link href="css/shop-homepage.css" rel="stylesheet"/>
        <!--<link rel="stylesheet" href="css/form.css" />-->

    </head>


    <body>
 
        <!-- Navigation -->
        <nav class="navbar navbar-expand navbar-dark bg-dark fixed-top" id="relou" >
            <jsp:include page="common/header.jsp"/>
        </nav>

        <!-- Page Content -->
       
<div class="container">
            <div class="row">

                <div class="col-lg-3">
                    <jsp:include page="common/navigation.jsp"/>
                </div>
                <!-- /.col-lg-3 -->

                <!-- Partie de Content a changer par rapport au besoin -->
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
                <div class="col-lg-9">

                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="images/youssef.jpg"  alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="images/jo.png"alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="images/izet.jpg"  alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>


                  

                    <br>


                    <div class="row"> 

                        <c:forEach var="booksPage" items="${booksDetails}" >
                            <c:forEach var="bookRow" items="${booksPage}" >
                                <div class="col-lg-4 col-md-6 mb-4">
                                    <div class="card h-100">
                                        <a href="controller?showBook&isbnBook=${bookRow.numISBNBook}"><img class="card-img-top" src="${bookRow.pathIconBook}" alt=""></a>
                                        <div class="card-body">
                                            <h4 class="card-title">
                                                <a href="controller?showBook&isbnBook=${bookRow.numISBNBook}">${bookRow.titleBook}</a>
                                            </h4>
                                            <h5>${bookRow.unitCostBook}€</h5>
                                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                                            <a   href="controller?section=panier&add=+ ${bookRow.numISBNBook}" style="margin-left: 30px" class="btn btn-outline-success">
                                               
                                                 <img  src="images/cart.png" >Ajouter au panier
                                                
                                            </a> 

                                        </div>
                                        <div class="card-footer ">
                                            <small class="text-muted">
                                                <c:if test="${bookRow.moyenne == -1}">
                                                    Note :  Pas encore d'évaluation.
                                                </c:if>
                                                <c:if test="${bookRow.moyenne== 0}">
                                                    Note : &#x2b50; &#x2b50; &#x2b50; &#x2b50; &#x2b50; <a href='controller?comment=${bookRow.numISBNBook}'>(${bookRow.nbNote} Notes)</a>
                                                </c:if>
                                                <c:if test="${bookRow.moyenne == 1}" >
                                                    Note : &#9733; &#x2b50; &#x2b50; &#x2b50; &#x2b50; <a href='controller?comment=${bookRow.numISBNBook}'>(${bookRow.nbNote} Notes)</a>
                                                </c:if>
                                                <c:if test="${bookRow.moyenne == 2 }" >
                                                    Note : &#9733; &#9733; &#x2b50; &#x2b50; &#x2b50; <a href='controller?comment=${bookRow.numISBNBook}'>(${bookRow.nbNote} Notes)</a>
                                                </c:if>
                                                <c:if test="${bookRow.moyenne == 3}">
                                                    Note : &#9733; &#9733; &#9733; &#x2b50; &#x2b50; <a href='controller?comment=${bookRow.numISBNBook}'>(${bookRow.nbNote} Notes)</a>
                                                </c:if>
                                                <c:if test="${bookRow.moyenne == 4}" >
                                                    Note : &#9733; &#9733; &#9733; &#9733; &#x2b50; <a href='controller?comment=${bookRow.numISBNBook}'>(${bookRow.nbNote} Notes)</a>
                                                </c:if>
                                                <c:if test="${bookRow.moyenne == 5}" >
                                                    Note : &#9733; &#9733; &#9733; &#9733; &#9733; <a href='controller?comment=${bookRow.numISBNBook}'>(${bookRow.nbNote} Notes)</a>
                                                </c:if>
                                            </small>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </c:forEach>

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

                <div class="col-sm-9"  id="pagination">

                    <ul class="pagination" >

                        <c:if test="${currentPage != 1}">
                            <li class="page-item"><a class="page-link" href="controller?section=pagination&pageHome=${currentPage - 1}">Previous</a></li>
                            </c:if>

                        <c:forEach begin="1" end="${noOfPages}" var="i">

                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <li class="active"><a class="page-link" href="#"> ${i}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    <li class="page-item"><a class="page-link" href="controller?section=pagination&pageHome=${i}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>

                        </c:forEach>
                        <c:if test="${currentPage lt noOfPages}">
                            <li class="page-item"><a class="page-link" href="controller?section=pagination&pageHome=${currentPage + 1}">Next</a></li> 
                            </c:if>
                    </ul>


                </div>  
                <!-- /.col-lg-9 -->
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
                <!--Fin de la partie de Content a changer par rapport au besoin -->


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
