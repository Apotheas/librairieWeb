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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="relou">
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



                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                            <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">

                            <div class="item active">
                                <a href="controller?carroussel=1">
                                    <img src="images/youssef.jpg" alt="youssef" style="width:100%;">
                                </a>
                                <div class="carousel-caption">

                                </div>
                            </div>

                            <div class="item">
                                <a href="controller?carroussel=2">
                                    <img src="images/jo.png" alt="jonathan" style="width:100%;">
                                </a>
                                <div class="carousel-caption">

                                </div>
                            </div>

                            <div class="item">
                                <a href="controller?carroussel=3">
                                    <img src="images/foued.jpg" alt="foued" style="width:100%;">
                                </a>
                                <div class="carousel-caption">

                                </div>
                            </div>
                            <div class="item">
                                <a href="controller?carroussel=4">
                                    <img src="images/izet.jpg" alt="izet" style="width:100%;">
                                </a>
                                <div class="carousel-caption">

                                </div>
                            </div>

                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <br>



                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->


                <!-- /.col-lg-9 -->
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
                <!--Fin de la partie de Content a changer par rapport au besoin -->


            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
                <center>
                <h3>  Accueil > Livres > ${book.titleBook} </h3> 
                <hr>
                <h3> <b> ${book.titleBook} </b></h3> 
<!--        <h4> <b> ${book.subTitleBook} </b></h4> -->

                 <h4><a href =""> Avis  </a> </h4> 

                <h4><a href =""> Donnez un avis  </a></h4> <br>

                <h4> Type : Livre </h4> 
                <h4> Support : Livre poche </h4> 
                <h4> Editeur : ${book.editor} </h4> 
                <h4> Author : 
                        <c:forEach var="author" items="${book.listAuthor}">
                            ${author.lastNameAuthor}  ${author.firstNameAuthor} \
                        </c:forEach>  </h4> 

                     <div>
                    <img src="${book.pathIconBook}" width="500" height="500"/> <br>  <h3> 
                    <center>
                        <h3> ${book.unitCostBook} euros </h3> 
                    <h3>Stock : ${book.stockBook}  </h3> 
                    <h4> <a href="controller?section=panier&add=+ ${book.numISBNBook}"> ajouter au panier  </a></h4> <br>  
                    <center>
                     </div>     

                    <article>

                        <p> <h3> Description : </h3></p> <br>
                    
                        <h4>  &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
                              ${book.synopsisBook}
                              &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp  
                        </h4>
                    
                    </article> <br><br> 
                        
                    </center>

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
