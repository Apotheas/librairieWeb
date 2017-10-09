
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Welcome</title>        
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
                            <form action='controller' method='post'> 
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

