<%-- 
    Document   : inscription
    Created on : 27 sept. 2017, 10:10:33
    Author     : cdi314
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>        
        <link type="text/css" rel="stylesheet" href="css/bootstrap/css/bootstrap.css" />
        <link type="text/css" rel="stylesheet" href="css/form.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
            <header class="row" id="header">
                <div class="col-lg-12" >
                    Entete
                </div>
            </header>

            <div class="row">

                <div class="col-lg-3" id="navBar">       
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#">Librairie</a>
                            </div>
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="homme">Home</a></li>
                                <li><a href="inscription">Inscription</a></li>
                                <li><a href="connexion">Se connecter</a></li>
                                <li><a href="#">Page 3</a></li>
                            </ul>
                        </div>
                    </nav> 

                </div>         






                <section class="col-lg-9">
                    <div class="form-group">
                        <form method="post" action="inscription">
                            <fieldset>
                                <legend>Inscription</legend>
                                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                                <label for="email">Adresse email <span class="requis">*</span></label>
                                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                                <span class="erreur">${form.erreurs['email']}</span>
                                <br />

                                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                                <span class="erreur">${form.erreurs['motdepasse']}</span>
                                <br />

                                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                                <span class="erreur">${form.erreurs['confirmation']}</span>
                                <br />

                                <label for="nom">Nom d'utilisateur</label>
                                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="20" />
                                <span class="erreur">${form.erreurs['nom']}</span>
                                <br />

                                <input type="submit" value="Inscription" class="sansLabel" />
                                <br />

                                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                            </fieldset>
                        </form> 
                    </div>
                </section>
            </div>
            <footer class="row" id="footer">
                Pied de page
            </footer>
        </div>
    </body>
</html>

























