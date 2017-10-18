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


                <!-- /.col-lg-3 -->


                <!-- Partie de Content a changer par rapport au besoin -->
                <!----------------------------------------------------------------->       
                <!------------------------------------------------------------------->
                <!-------------------------------------------------------------------->
                <jsp:useBean id="bCustomer" class="com.cdi.g3.web.beans.beanCustomer" scope="session" />

                
                <div class=" col-sm-3">
                    
                    <table id="customerProfile" border="0" cellspacing="4">

                        <!-- Personal information -->
                        <tr>
                            <td colspan="2"><strong>Details du compte</strong></td>
                        </tr>
                        <tr>
                            <td>Login :</td><td>${bCustomer.customer.loginCustomer}</td>
                        </tr>
                        <tr>
                            <td>Firstname :</td><td>${bCustomer.customer.firstNameCustomer}</td>
                        </tr>
                        <tr>
                            <td>Lastname :</td><td>${bCustomer.customer.lastNameCustomer}</td>
                        </tr>
                        <tr>
                            <td>Email :</td><td>${bCustomer.customer.emailCustomer}</td>
                        </tr>


                    </table>
                    
                </div>
                <!-- Address de Livraison-->
                <div class="col-sm-4">
                    
                    <table id="customerProfile" border="0" cellspacing="4">
                        <tr>
                            <td colspan="2"><strong>Address de Livraison</strong></td>
                        </tr>

                        <tr>
                            <td>Nom déstinataire :</td><td>${bCustomer.addressShip.nameReceiverAdress}</td>
                        </tr>

                        <tr>
                            <td>Nom de la société :</td><td>${bCustomer.addressShip.nameCompanyReceiverAdress}</td>
                        </tr>

                        <tr>
                            <td>N° :</td><td>${bCustomer.addressShip.numAdress}</td>
                        </tr>

                        
                        <tr>
                            <td>Adresse :</td><td>${bCustomer.addressShip.nameStreetAdress}</td>
                        </tr>    
                        <td>Complément :</td><td>${bCustomer.addressShip.nameStreet2Adress}</td>
                        </tr>

                        <tr>
                            <td>Code postale :</td><td>${bCustomer.addressShip.zipcodeAdress}</td>
                        </tr>

                        <tr>
                            <td>Ville :</td><td>${bCustomer.addressShip.cityAdress}</td>
                        </tr>

                        <tr>
                            <td>Pays :</td><td>${bCustomer.addressShip.countryAdress}</td>
                        </tr>

                    </table> 
                    
                </div>
                <!-- Address de la commande-->

                <table id="customerProfile" border="0" cellspacing="4">
                    <tr>
                        <td colspan="2"><strong>Addresse de facturation</strong></td>
                    </tr>

                    <tr>
                        <td>Nom déstinataire :</td><td>${bCustomer.addressBill.nameReceiverAdress}</td>
                    </tr>

                    <tr>
                        <td>Nom de la société :</td><td>${bCustomer.addressBill.nameCompanyReceiverAdress}</td>
                    </tr>

                    <tr>
                        <td>N° :</td><td>${bCustomer.addressBill.numAdress}</td>
                    </tr>

                    
                    <tr>
                        <td>Adresse :</td><td>${bCustomer.addressBill.nameStreetAdress}</td>
                    </tr>    
                    <td>Complément :</td><td>${bCustomer.addressBill.nameStreet2Adress}</td>
                    </tr>

                    <tr>
                        <td>Code postale :</td><td>${bCustomer.addressBill.zipcodeAdress}</td>
                    </tr>

                    <tr>
                        <td>Ville :</td><td>${bCustomer.addressBill.cityAdress}</td>
                    </tr>

                    <tr>
                        <td>Pays :</td><td>${bCustomer.addressBill.countryAdress}</td>
                    </tr>


                </table>  
                   
                 
                    <h2>Historique des commandes</h2>
                   
                <table class="table table-striped">

                    <thead>
                        <tr>
                            <th>Numero</th>
                            <th>Status</th>
                            <th>Date de la Commande</th>
                            <th>Total TTC</th>
                           
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${bCustomer.orderList}">
                            <tr>
                            <td>${order.internalNumOrder}</td>
                            <td>${order.nameInfoStatus}</td>
                            <td>${order.dateOrder}</td>
                            
                            </tr>
                        </c:forEach>
                        
                      
                    </tbody>
                </table>
                    

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
