

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


        <!-- Partie de Content a changer par rapport au besoin -->
        <!----------------------------------------------------------------->       
        <!------------------------------------------------------------------->
        <!-------------------------------------------------------------------->

        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <table cellspacing="0" cellpadding="5" width="100%">
                    <tr>
                    <td align="left" valign="top" width="60%">
                        <%--CENTRAL BODY--%>
                        <P><strong>Your Order is Complete</strong></P>
                        <P>Your order id is ${requestScope.orderId}</P>
                        <P>Thank you for shopping with the librairy</P>
                        <%--FOOTER--%>
                    </td>
                    <td></td>
                    </tr>

                </table> 


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
