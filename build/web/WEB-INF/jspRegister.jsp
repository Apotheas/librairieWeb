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
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"> -->
        <link href="css/vendor/bootstrap/css/bootstrap.css"  rel="stylesheet" /> -->
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

                <div class="col-lg-9">
                    <!-- Partie de Content a changer par rapport au besoin -->
                    <!----------------------------------------------------------------->       
                    <!------------------------------------------------------------------->
                    <!-------------------------------------------------------------------->
                    <form action='controller' method='post'>                                
                        <fieldset>
                            <legend>Inscription</legend>
                            <p>Vous pouvez vous inscrire via ce formulaire.</p>

                            <label for="login">Login <span class="requis">*</span></label>
                            <input type="login" id="login" name="login" value="<c:out value="${beanCustomer.login}"/>" size="20" maxlength="60" />
                            <span class="erreur">${form.erreurs['login']}</span>
                            <br />

                            <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                            <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" />
                            <span class="erreur">${form.erreurs['motdepasse']}</span>
                            <br />

                            <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                            <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                            <span class="erreur">${form.erreurs['confirmation']}</span>
                            <br />

                            <label for="nom">Nom </label>
                            <input type="text" id="nom" name="nom" value="<c:out value="${beanCustomer.lastName}"/>" size="20" maxlength="20" />
                            <span class="erreur">${form.erreurs['nom']}</span>
                            <br />

                            <label for="nom">Prénom </label>
                            <input type="text" id="nom" name="nom" value="<c:out value="${beanCustomer.firstName}"/>" size="20" maxlength="20" />
                            <span class="erreur">${form.erreurs['nom']}</span>
                            <br />

                            <label for="email">Adresse email <span class="requis">*</span></label>
                            <input type="email" id="email" name="email" value="<c:out value="${beanCustomer.email}"/>" size="20" maxlength="60" />
                            <span class="erreur">${form.erreurs['email']}</span>
                            <br />

                            <input type="submit" value="Inscription" class="sansLabel" />
                            <br />
                            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                        </fieldset>
                    </form>               

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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
