<%@page import="com.cdi.g3.server.domain.catalog.Book"%>
<%@page import="com.cdi.g3.web.beans.beanCustomer"%>
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
            <jsp:useBean id="bCustomer" class="com.cdi.g3.web.beans.beanCustomer" scope="session" />

            <div class="row">
                <div  class="col-lg-12">

                    <form action='controller?section=customer&update=true' method='POST'>                                
                        <fieldset>
                            <legend>Mon profil</legend>

                            <label for="login">Login </label>
                            <input disabled="true" type="login" id="login" name="login" value="<c:out value="${bCustomer.customer.loginCustomer}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.erreurs['loginCustomer']}</span>
                            <br />

                            <label for="nom">Nom <span class="requis">*</span> </label>
                            <input type="text" id="nom" name="nom" value="<c:out value="${bCustomer.customer.lastNameCustomer}"/>" size="20" maxlength="20" />
                            <span class="erreur"><c:out value="${bCustomer.erreurs['lastNameCustomer']}"/></span>                            
                            <br />

                            <label for="nom">Prénom <span class="requis">*</span></label>
                            <input type="text" id="nom" name="prenom" value="<c:out value="${bCustomer.customer.firstNameCustomer}"/>" size="20" maxlength="20" />
                            <span class="erreur">${bCustomer.erreurs['firstNameCustomer']}</span>
                            <br />

                            <label for="nom">Téléphone </label>
                            <input type="text" id="telephoneCustomer" name="telephoneCustomer" value="<c:out value="${bCustomer.customer.telephoneCustomer}"/>" size="20" maxlength="20" />
                            <br />

                            <label  for="email">Adresse email </label>
                            <input disabled="true" type="email" id="email" name="email" value="<c:out value="${bCustomer.customer.emailCustomer}"/>" size="20" maxlength="60" />
                            <span class="erreur">${bCustomer.erreurs['emailCustomer']}</span>
                            <br />
                            <input type="submit" name='doIt' value="Modifier mes informations"  class="btn btn-primary"/>
                            <br />
                            <p class="${empty bCustomer.erreurs ? 'succes' : 'erreur'}">${bCustomer.resultat}</p>

                        </fieldset>
                    </form>               


                </div>




            </div>      
            <!-- /.row -->


            <div class="row">


                <!-- Address de Livraison-->    
                <div class="col-lg-6">                        
                    <br> <br>                        
                    <strong>Adresse de Livraison</strong>

                    <form name="AddressShipping"  action="controller?section=order&AddAddressesOrder"  method="GET">
                        <input type="hidden" value="customer" name="provenance" />
                        <label for="addressShip">Selectionner une adresse de livraison </label>
                        <select name="addressShip">
                            <c:forEach var="addressShip" items="${sessionScope.bCustomer.addressShipList}">
                                <option value="${addressShip.idAdress}">${addressShip.idAdress}</option>
                            </c:forEach>
                        </select>

                        <input type="submit" value="Ok" name="selectAddressShip" class="btn btn-primary"/>
                    </form>

                    <br> <br>
                    <form action='controller?section=order&AddAddressesOrder' method='post'>  
                         <input type="hidden" value="customer" name="provenance" />
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

                            <input type="submit" value="Modifier Adresse de Livraison" name="updateAddressShip" class="btn btn-primary"/>

                           
                            <br />
                            <p class="${empty bCustomer.bAddress.erreurs ? 'succes' : 'erreur'}">${bCustomer.bAddress.resultat}</p>
                        </fieldset>
                    </form> 
                </div>


                <div  class="col-lg-6">
                    <br> <br>
                    <strong>Adresse de Facturation</strong>

                    <form name="shipping" action='controller?section=order&AddAddressesOrder' method="GET">
                         <input type="hidden" value="customer" name="provenance" />
                        <label for="addressBill">Selectionner une adresse de facturation</label>
                        <select name="addressBill">
                            <c:forEach var="addressBill" items="${sessionScope.bCustomer.addressBillList}">
                                <option value="${addressBill.idAdress}">${addressBill.idAdress}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Ok" name="selectAddressBill" class="btn btn-primary"/>
                    </form> 


                    <br> <br>
                    <form action='controller?section=order&AddAddressesOrder'  method='post'> 
                         <input type="hidden" value="customer" name="provenance" />
                        <fieldset>
                            <legend>Adresse de Facturation</legend>
                            <input type="hidden" id="idAddress" name="idAddress" value="<c:out value="${bCustomer.addressBill.id}"/>" />


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
                            <input type="nameStreetAdress" id="nameStreetAdress" name="nameStreetAdress" value="<c:out value="${bCustomer.addressBill.nameStreetAdress}"/>" size="20" maxlength="60" />
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
                            <input type="cityAdress" id="cityAdress" name="cityAdress" value="<c:out value="${bCustomer.addressBill.cityAdress}"/>" size="20" maxlength="60" />
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


            </div> 
            <!-- /.row -->


            <div class="row py-5">
                <h2>Historique des commandes</h2>

                <table class="table table-striped">

                    <thead>
                        <tr>
                            <th>Numero</th>
                            <th>Status</th>
                            <th>Date de la Commande</th>
                            <th>Total TTC</th>
                            <th>Detail</th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${bCustomer.orderList}">
                            <tr>
                                <td>${order.internalNumOrder}</td>
                                <td>${order.nameInfoStatus}</td>
                                <td>${order.dateOrder}</td>
                                <td>${order.getTotalPrice()}€</td>
                                <td><div class="modal-body">
                                        <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
                                            <i style="width: 50%"> Afficher</i>
                                        </button>    </td>
                                <!-- MODAL BUTTON AFFICHER     -->
                        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark">
                                        <h5 class="modal-title" style="color: white" id="exampleModalLongTitle">Numero de commande : ${order.internalNumOrder}</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>

                                    <div class="modal-body">
                                        Adresse de livraison : ${bCustomer.addressShip}<hr>
                                        <c:forEach var="line" items="${order.listOrderLines}">

                                            <a href="controller?showBook&isbnBook=${line.book.numISBNBook}"><img style="width: 20%" src="${line.book.pathIconBook}" alt=""></a>
                                            ${line.book.titleBook}  |Qte :&nbsp; ${line.quantityOrderLine}|Prix :&nbsp;${line.unitCostOrderLine}€<hr>

                                        </c:forEach>
                                    </div>
                                    <div class="modal-footer bg-dark">
                                        <i class=" bg-primary align-content-center "  > <h6 style="color: white">TOTAL&nbsp;:&nbsp;${order.getTotalPrice()}€</h4></i>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </div>
            <!-- /.row -->
            <!----------------------------------------------------------------->       
            <!------------------------------------------------------------------->
            <!-------------------------------------------------------------------->
            <!--Fin de la partie de Content a changer par rapport au besoin -->

            <!-- /.col-lg-9 -->




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
