
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
                            <h1>Hello ${Welcome}!</h1>
                            On vous souhaite une bonne viste sur notre librairie
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

