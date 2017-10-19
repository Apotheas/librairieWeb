

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

                <div class="col-lg-6">
                     <br>  <br>
                    <fieldset>
                        <div id="legend">
                            <legend class="">Information de la commande</legend>
                        </div>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th class="text-center"></th>

                                </tr>
                            </thead>
                            <tbody>

                                <tr>

                                    <td></td>
                                    <td></td>
                                    <td></td>  

                                    <td><h5>Total HT</h5></td>
                                    <td class="text-right"><h5><strong>${sessionScope.subTotalHT}€</strong></h5></td>
                                </tr>


                                <tr>

                                    <td></td>
                                    <td></td>
                                    <td></td>

                                    <td><h5>Frais de Port</h5></td>
                                    <td class="text-right"><h5><strong>${sessionScope.fraisPort}€</strong></h5></td>
                                </tr>


                                <tr>

                                    <td></td>
                                    <td></td>
                                    <td></td>

                                    <td><h3>Total</h3></td>
                                    <td class="text-right"><h3><strong>${TotalHTAvecFraisPort}€</strong></h3></td>
                                </tr>


                        </table>

                    </fieldset>

                </div>


                <div class="col-lg-6">
                    <div class="row-fluid">
                        <form action="controller?section=order&checkOut=true" class="form-horizontal" method="post">
                            <br>  <br>

                            <fieldset>
                                <div id="legend">
                                    <legend class="">Payment</legend>
                                </div>

                                <!-- Name -->
                                <div class="control-group">
                                    <label class="control-label"  for="username">Nom titulaire carte</label>
                                    <div class="controls">
                                        <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                                    </div>
                                </div>
                                <br>

                                <!-- Card Number -->
                                <div class="control-group">
                                    <label class="control-label" for="email">Numéro carte</label>
                                    <div class="controls">
                                        <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                                    </div>
                                </div>

                                <br>

                                <!-- Expiry-->
                                <div class="control-group">
                                    <label class="control-label" for="password">Date d'éxpiration</label>
                                    <div class="controls">
                                        <select class="span3" name="expiry_month" id="expiry_month">
                                            <option></option>
                                            <option value="01">Jan (01)</option>
                                            <option value="02">Feb (02)</option>
                                            <option value="03">Mar (03)</option>
                                            <option value="04">Apr (04)</option>
                                            <option value="05">May (05)</option>
                                            <option value="06">June (06)</option>
                                            <option value="07">July (07)</option>
                                            <option value="08">Aug (08)</option>
                                            <option value="09">Sep (09)</option>
                                            <option value="10">Oct (10)</option>1
                                            <option value="11">Nov (11)</option>
                                            <option value="12">Dec (12)</option>
                                        </select>
                                        <select class="span2" name="expiry_year">
                                            <option value="13">2013</option>
                                            <option value="14">2014</option>
                                            <option value="15">2015</option>
                                            <option value="16">2016</option>
                                            <option value="17">2017</option>
                                            <option value="18">2018</option>
                                            <option value="19">2019</option>
                                            <option value="20">2020</option>
                                            <option value="21">2021</option>
                                            <option value="22">2022</option>
                                            <option value="23">2023</option>
                                        </select>

                                    </div>
                                </div>
                                <br>
                                <!-- CVV -->
                                <div class="control-group">
                                    <label class="control-label"  for="password_confirm">Numéro CVV</label>
                                    <div class="controls">
                                        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="span2">
                                    </div>
                                </div>
                                <br>

                                <!-- Save card 
                                <div class="control-group">
                                    <div class="controls">
                                        
                                        <label class="checkbox" for="save_card">
                                            <input type="checkbox" id="save_card" value="option1">
                                            Save card on file?
                                        </label>
                                        
                                    </div>
                                </div>
                                -->

                                <!-- Submit -->
                                <div class="control-group">

                                    <div class="controls">                                        
                                        <a href="controller?section=order&checkOut=true"  >
                                            <button type="submit"class="btn btn-success">Payer</button>
                                        </a>
                                    </div>
                                </div>

                            </fieldset>
                        </form>
                    </div>


                </div>
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
