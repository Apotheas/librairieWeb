

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


        <!-- Partie de Content a changer par rapport au besoin -->
        <!----------------------------------------------------------------->       
        <!------------------------------------------------------------------->
        <!-------------------------------------------------------------------->
        <!-- Page Content -->
        <div class="container">
            <div class="row">

                <div class="col-lg-12">  

                    <fieldset>
                        <legend>Information Client</legend>

                        <label for="login">Login </label>
                        <input disabled="true" type="login" id="login" name="login" value="<c:out value="${bCustomer.customer.loginCustomer}"/>" size="20" maxlength="60" />

                        <br />

                        <label for="nom">Nom  </label>
                        <input disabled="true" type="text" id="nom" name="nom" value="<c:out value="${bCustomer.customer.lastNameCustomer}"/>" size="20" maxlength="60" />

                        <br />

                        <label for="nom">Prénom</label>
                        <input disabled="true" type="text" id="prenom" name="prenom" value="<c:out value="${bCustomer.customer.firstNameCustomer}"/>" size="20" maxlength="60" />

                        <br />

                        <label for="email">Adresse email </label>
                        <input disabled="true" type="email" id="email" name="email" value="<c:out value="${bCustomer.customer.emailCustomer}"/>" size="20" maxlength="60" />

                        <br />



                    </fieldset>
                </div>
                <!-- /.col-lg-12 -->

            </div>
            <!-- /.row -->



            <div class="row">

                <div class="col-lg-6">                       
                    <br> <br>                        
                    <strong>Adresse de Livraison</strong>
                    
                    
                    

                    <form name="AddressShipping"  action="controller?section=order&AddAddressesOrder"  method="POST">
                        <input type="hidden" value="order" name="provenance" />
                        <label for="addressShip">Selectionner une adresse de livraison </label>
                        <select name="addressShip">
                            <c:forEach var="addressShip" items="${sessionScope.bCustomer.addressShipList}">
                                <option value="<c:out value="${addressShip.idAdress}"/>"> ${addressShip} </option>
                            </c:forEach>
                        </select>

                        <input type="submit" value="Ok" name="selectAddressShip" />
                    </form>

                    <br> <br>
                    <form action='controller?section=order&AddAddressesOrder' method='post'> 
                        <input type="hidden" value="order" name="provenance" />
                        <fieldset>
                            <legend>Adresse de Livraison</legend>

                            <input type="hidden" id="idAddress" name="idAddress" value="<c:out value="${bCustomer.addressShip.id}"/>" />
                            <input type="hidden" value="${addressShip.idAdress}" name="valeurId" />

                            <label for="nameReceiverAdress">Nom déstinataire :<span class="requis">*</span></label>
                            <input type="nameReceiverAdress" id="nameReceiverAdress" name="nameReceiverAdress" value="<c:out value="${bCustomer.addressShip.nameReceiverAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['nameReceiverAdress']}</span>
                            <br />

                            <label for="nameCompanyReceiverAdress">Nom de la société :</label>
                            <input type="nameCompanyReceiverAdress" id="nameCompanyReceiverAdress" name="nameCompanyReceiverAdress" value="<c:out value="${bCustomer.addressShip.nameCompanyReceiverAdress.nameCompany}"/>" size="20" maxlength="60" />
                            <br />


                            <label for="typeStreetAdress"> Type Adresse :</label>
                            <input type="typeStreetAdress" id="typeStreetAdress" name="typeStreetAdress" value="<c:out value="${bCustomer.addressShip.typeStreetAdress}"/>" size="20" maxlength="60" />

                            <br />

                            <label for="numAdress">N°  :<span class="requis">*</span></label>
                            <input type="numAdress" id="numAdress" name="numAdress" value="<c:out value="${bCustomer.addressShip.numAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['numAdress']}</span>
                            <br />



                            <label for="nameStreetAdress">Adresse  :<span class="requis">*</span></label>
                            <input type="nameStreetAdress" id="nameStreetAdress" name="nameStreetAdress" value="<c:out value="${bCustomer.addressShip.nameStreetAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['nameStreetAdress']}</span>
                            <br />

                            <label for="nameStreetAdress"> Complément :</label>
                            <input type="nameStreet2Adress" id="nameStreet2Adress" name="nameStreet2Adress" value="<c:out value="${bCustomer.addressShip.nameStreet2Adress}"/>" size="20" maxlength="60" />

                            <br />

                            <label for="zipcodeAdress">Code postale  :<span class="requis">*</span></label>
                            <input type="zipcodeAdress" id="zipcodeAdress" name="zipcodeAdress" value="<c:out value="${bCustomer.addressShip.zipcodeAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['zipcodeAdress']}</span>
                            <br />


                            <label for="cityAdress">Ville  :<span class="requis">*</span></label>
                            <input type="cityAdress" id="cityAdress" name="cityAdress" value="<c:out value="${bCustomer.addressShip.cityAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['cityAdress']}</span>
                            <br />

                            <label for="countryAdress">Pays  :<span class="requis">*</span></label>
                            <input type="countryAdress" id="countryAdress" name="countryAdress" value="<c:out value="${bCustomer.addressShip.countryAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['countryAdress']}</span>
                            <br /><br />

                            <input type="submit" value="Modifier Adresse de Livraison" name="updateAddressShip" class="btn btn-primary" />

                            <br />
                            <p class="${empty bCustomer.bAddress.erreurs ? 'succes' : 'erreur'}">${bCustomer.bAddress.resultat}</p>
                        </fieldset>
                    </form> 
                </div>

                <div class="col-lg-6">  
                    <br> <br>
                    <strong>Adresse de Facturation</strong>

                    <form name="shipping" action='controller?section=order&AddAddressesOrder' method="POST">
                        <input type="hidden" value="order" name="provenance" />
                        <label for="addressBill">Selectionner une autre adresse </label>
                        <select name="addressBill">
                            <c:forEach var="addressBill" items="${sessionScope.bCustomer.addressBillList}">
                                <option value="<c:out value="${addressBill.idAdress}"/>">${addressBill}</option>                                
                            </c:forEach>
                        </select>
                        <input type="submit" value="Ok" name="selectAddressBill" />
                    </form> 


                    <br> <br>
                    <form action='controller?section=order&AddAddressesOrder'  method='post'>            
                        <fieldset>
                            <legend>Adresse de Facturation</legend>
                            <input type="hidden" id="idAddress" name="idAddress" value="<c:out value="${bCustomer.addressBill.id}"/>" />
                            <input type="hidden" value="order" name="provenance" />

                            <label for="nameReceiverAdress">Nom déstinataire :<span class="requis">*</span></label>
                            <input type="nameReceiverAdress" id="nameReceiverAdress" name="nameReceiverAdress" value="<c:out value="${bCustomer.addressBill.nameReceiverAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['nameReceiverAdress']}</span>
                            <br />

                            <label for="nameCompanyReceiverAdress">Nom de la société :</label>
                            <input type="nameCompanyReceiverAdress" id="nameCompanyReceiverAdress" name="nameCompanyReceiverAdress" value="<c:out value="${bCustomer.addressBill.nameCompanyReceiverAdress.nameCompany}"/>" size="20" maxlength="60" />
                            <br />


                            <label for="typeStreetAdress"> Type Adresse :</label>
                            <input type="typeStreetAdress" id="typeStreetAdress" name="typeStreetAdress" value="<c:out value="${bCustomer.addressBill.typeStreetAdress}"/>" size="20" maxlength="60" />

                            <br />

                            <label for="numAdress">N°  :<span class="requis">*</span></label>
                            <input type="numAdress" id="numAdress" name="numAdress" value="<c:out value="${bCustomer.addressBill.numAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['numAdress']}</span>
                            <br />



                            <label for="nameStreetAdress">Adresse  :<span class="requis">*</span></label>
                            <input  type="nameStreetAdress" id="nameStreetAdress" name="nameStreetAdress" value="<c:out value="${bCustomer.addressBill.nameStreetAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['nameStreetAdress']}</span>
                            <br />

                            <label for="nameStreetAdress"> Complément :</label>
                            <input type="nameStreet2Adress" id="nameStreet2Adress" name="nameStreet2Adress" value="<c:out value="${bCustomer.addressBill.nameStreet2Adress}"/>" size="20" maxlength="60" />

                            <br />

                            <label for="zipcodeAdress">Code postale  :<span class="requis">*</span></label>
                            <input type="zipcodeAdress" id="zipcodeAdress" name="zipcodeAdress" value="<c:out value="${bCustomer.addressBill.zipcodeAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['zipcodeAdress']}</span>
                            <br />


                            <label for="cityAdress">Ville  :<span class="requis">*</span></label>
                            <input required type="cityAdress" id="cityAdress" name="cityAdress" value="<c:out value="${bCustomer.addressBill.cityAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['cityAdress']}</span>
                            <br />

                            <label for="countryAdress">Pays  :<span class="requis">*</span></label>
                            <input type="countryAdress" id="countryAdress" name="countryAdress" value="<c:out value="${bCustomer.addressBill.countryAdress}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.bAddress.erreurs['countryAdress']}</span>
                            <br /><br />
                            <input type="submit" value="Modifier Adresse de Facturation" name="updateAddressBill" class="btn btn-primary"/>

                            <br />
                            <p class="${empty bCustomer.bAddress.erreurs ? 'succes' : 'erreur'}">${bCustomer.bAddress.resultat}</p>

                        </fieldset> 
                    </form> 

                </div>
                <br> <br>

                <div class="modal-body">

                    <form action="controller?section=order&VerifCreditCardOrder=true" method="POST">
                         <c:if test="${!retour==ok}">
                        <p> L'adresse de facturation et de livraisont doivent etre remplies </p> 
                        </c:if>
                        <input type="hidden" id="idAddressShip" name="idAddressShip" value="<c:out value="${bCustomer.addressShip.idAdress}"/>" />
                        <input type="hidden" id="idAddressBill" name="idAddressBill" value="<c:out value="${bCustomer.addressBill.idAdress}"/>" />
                        <input  type="submit" value="Suivant" name="DoIt" class="btn btn-primary"/> 
                        
                       
                    </form>
                   
                </div>
 



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
