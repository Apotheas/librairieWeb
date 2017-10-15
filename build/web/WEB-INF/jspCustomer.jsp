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
       <jsp:useBean id="bCustomer" class="com.cdi.g3.web.beans.beanCustomer" scope="session" />
                    
            <h2>Your Account Information</h2>

            <table id="customerProfile" border="0" cellspacing="4">

                <!-- Personal information -->
                <tr>
                    <td colspan="2"><strong>Personal information</strong></td>
	            </tr>
                    <tr>
		            <td>Firstname :</td><td>${bCustomer.customer.loginCustomer}</td>
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
                    <tr>
                        <td>Email :</td><td>${bCustomer.customer.nameCompanyCustomer}</td>
	            </tr>
                
                 <!-- Address de Livraison-->
	            <tr>
		            <td colspan="2"><strong>Address de Livraison</strong></td>
	            </tr>
	            
                    <tr>
		            <td>Nom déstinataire :</td><td>${bCustomer.addressShip.nameReceiverAdress}</td>
	            </tr>
                    
                    <tr>
		            <td>Nom de la société déstinataire :</td><td>${bCustomer.addressShip.nameCompanyReceiverAdress}</td>
	            </tr>
	            
                    <tr>
		            <td>N° :</td><td>${bCustomer.addressShip.numAdress}</td>
	            </tr>
                    
                     <tr>
		            <td>N° :</td><td>${bCustomer.addressShip.typeStreetAdress}</td>
	            </tr>
                    <tr>
		            <td>Adresse :</td><td>${bCustomer.addressShip.nameStreetAdress}</td>
	            </tr>    
		            <td>Complément d'adresse :</td><td>${bCustomer.addressShip.nameStreet2Adress}</td>
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
	            
                    
                     <!-- Address de la commande-->
                    
                    <tr>
		            <td colspan="2"><strong>Address de la commande</strong></td>
	            </tr>
	            
                    <tr>
		            <td>Nom déstinataire :</td><td>${bCustomer.addressBill.nameReceiverAdress}</td>
	            </tr>
                    
                    <tr>
		            <td>Nom de la société déstinataire :</td><td>${bCustomer.addressBill.nameCompanyReceiverAdress}</td>
	            </tr>
	            
                    <tr>
		            <td>N° :</td><td>${bCustomer.addressBill.numAdress}</td>
	            </tr>
                    
                     <tr>
		            <td>N° :</td><td>${bCustomer.addressBill.typeStreetAdress}</td>
	            </tr>
                    <tr>
		            <td>Adresse :</td><td>${bCustomer.addressBill.nameStreetAdress}</td>
	            </tr>    
		            <td>Complément d'adresse :</td><td>${bCustomer.addressBill.nameStreet2Adress}</td>
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
