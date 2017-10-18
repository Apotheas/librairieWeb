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
        <div class="container" >

            <div class="row">

                <div class="col-lg-9">

                    <!-- Partie de Content a changer par rapport au besoin -->
                    <!----------------------------------------------------------------->       
                    <!------------------------------------------------------------------->
                    <!-------------------------------------------------------------------->
                    <form action='controller?section=login' method='post'> 
                        <fieldset>
                            <legend>Connexion</legend>
                            <p>Vous pouvez vous connecter via ce formulaire.</p>
                            <label for="nom">Login <span class="requis">*</span></label>                                
                            <input type="hidden" name="section" value="login"/>
                            <input type='text' id="login" name='login' value='${user}' size="20" maxlength="60" /><br>
                            <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                            <input type='password' id="password" name='password' size="20" maxlength="20" /></br>
                            <input type='submit' name='doIt' value='Connexion' /><br>                           
                        </fieldset>
                    </form> 
                    <font color="red">${msg}</font>
                    <!-- /.col-lg-9 -->
                    <!----------------------------------------------------------------->       
                    <!------------------------------------------------------------------->
                    <!-------------------------------------------------------------------->
                    <!--Fin de la partie de Content a changer par rapport au besoin -->
                </div>
                <!-- /.col-lg-9 -->

                <div class="col-lg-3">
                    <h2> Première visite ? </h2>
                    <p>Bonjour cher inconnu. On ne se connaît pas encore... aucun problème, faisons connaissance :)</p>

                    <a   href="controller?section=customer&addCustomer=true">
                        <button  style="margin-left: 100px"  type="button" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continuer
                        </button>
                    </a> 


                </div>

                 <!-- /.col-lg-3 -->


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
