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

                <div class="col-lg-9" >
                    <!-- Partie de Content a changer par rapport au besoin -->
                    <!----------------------------------------------------------------->       
                    <!------------------------------------------------------------------->
                    <!-------------------------------------------------------------------->
                   <jsp:useBean id="bCustomer" class="com.cdi.g3.web.beans.beanCustomer" scope="session" />
                    
                   
                   <form action='controller?section=customer&addCustomer=true' method='post'>                                
                        <fieldset>
                            <legend>Inscription</legend>
                            <p>Vous pouvez vous inscrire via ce formulaire.</p>
                             <input type="hidden" id="passOrder" name="passOrder" value="<c:out value="${passOrder}"/>" />

                            <label for="login">Login <span class="requis">*</span></label>
                            <input type="login" id="login" name="login" value="<c:out value="${bCustomer.customer.loginCustomer}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.erreurs['loginCustomer']}</span>
                            <br />

                            <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                            <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" />
                            <span class="erreur">${bCustomer.erreurs['passwordCustomer']}</span>
                            <br />

                            <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                            <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                            <span class="erreur">${bCustomer.erreurs['confirmationPassword']}</span>
                            <br /><br />

                            <label for="nom">Nom <span class="requis">*</span> </label>
                            <input type="text" id="nom" name="nom" value="<c:out value="${bCustomer.customer.lastNameCustomer}"/>" size="20" maxlength="20" />
                            <span class="erreur"><c:out value="${bCustomer.erreurs['lastNameCustomer']}"/></span>                            
                            <br />

                            <label for="nom">Prénom <span class="requis">*</span></label>
                            <input type="text" id="nom" name="prenom" value="<c:out value="${bCustomer.customer.firstNameCustomer}"/>" size="20" maxlength="20" />
                            <span class="erreur">${bCustomer.erreurs['firstNameCustomer']}</span>
                            <br />

                            <label for="email">Adresse email <span class="requis">*</span></label>
                            <input type="email" id="email" name="email" value="<c:out value="${bCustomer.customer.emailCustomer}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.erreurs['emailCustomer']}</span>
                            <br />
                            <input type="submit" name='doIt' value="Creer un compte" class="sansLabel" class="btn btn-primary" />
                            <br />
                            <p class="${empty bCustomer.erreurs ? 'succes' : 'erreur'}">${bCustomer.resultat}</p>
                            
                            
                            <c:if test="${empty bCustomer.erreurs }">
                                <c:if test="${passOrder==true}">
                                    <a href="controller?section=panier&affichePanier"> Revenir à mon panier</a>
                                    
                                </c:if>
                                
                            </c:if>
                            
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
