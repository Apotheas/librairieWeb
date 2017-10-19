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

          

                <!-- /.col-lg-3 -->

                <!-- Partie de Content a changer par rapport au besoin -->
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
               



                  



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
                
                <h3>  Accueil > Livres > ${book.titleBook} </h3> 
                <hr>
                <h2> <b> ${book.titleBook} </b></h2> 
<!--        <h4> <b> ${book.subTitleBook} </b></h4> -->

                

                <h4> Type : Livre          Support : Livre poche        Editeur : ${book.editor}</h4> 
                <h4> Author : 
                        <c:forEach var="author" items="${book.listAuthor}">
                            ${author.lastNameAuthor}  ${author.firstNameAuthor} 
                        </c:forEach>  </h4> 

                     <div class="row">
                       
                    <img  class="col-sm-4"   src="${book.pathIconBook}" width="500" height="500"/> 
                         
                    
                      <article class="col-sm-8">
                         <p>
                    <font size=17>        Prix : ${book.unitCostBook} euros <br>   Stock : ${book.stockBook} <br> </font>  
                    
                      <a  class="btn btn-primary"  href="controller?section=panier&add=+ ${book.numISBNBook}"> ajouter au panier  </a> <br>
                       
                       
                     
                   
                    <article>

                        <p> <h3> Description : </h3></p> <br>
                    
                        <h4>  
                              ${book.synopsisBook}
                             
                        </h4>
                    
                    </article> <br><br> 
                     
                     
                
                    
                        <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
  Afficher les commentaires
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Commentaires</h5>
        
      </div>
      <div class="modal-body">
     
                          <c:forEach var="appreciation" items="${book.getAppList()}">
                              ${appreciation.loginCustomerAppreciate}  ( ${appreciation.dateAppreciate} ) :  ${appreciation.commentAppreciate} <hr>
                          </c:forEach>   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Add comment</button>
      </div>
    </div>
  </div>
</div>

                      
                        

                    </div>    
 
                        
                 
                   
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
