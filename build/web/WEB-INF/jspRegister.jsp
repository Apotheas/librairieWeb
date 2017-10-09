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

