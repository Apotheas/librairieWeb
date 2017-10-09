<%@page import="com.cdi.g3.server.domain.catalog.Book"%>
<%@page import="com.cdi.g3.web.beans.beanCatalog"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Homme</title>        
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
                    <c:forEach var="booksPage" items="${applicationScope.booksDetails}" >                         

                        <div class="row">
                            <c:forEach var="bookRow" items="${booksPage}">
                                <div class="col-sm-3">
                                    <h2>${bookRow.titleBook}</h2>
                                    <p> ${bookRow.synopsisBook}</p>                  
                                    <img src="${bookRow.pathIconBook}" class="img-responsive" alt="Cinque Terre" width="304" height="236"> 
                                    <a href="controller?section=panier&add=+ ${bookRow.numISBNBook}">Add Cart</a> 
                                </div>
                            </c:forEach>
                        </div>  
                    </c:forEach>

                    <div class="row">
                        <div class="col-sm-9">

                            <ul class="pagination">

                                <c:if test="${currentPage != 1}">
                                    <li class="page-item"><a class="page-link" href="controller?section=pagination&pageHome=${currentPage - 1}">Previous</a></li>
                                    </c:if>

                                <c:forEach begin="1" end="${applicationScope.noOfPages}" var="i">

                                    <c:choose>
                                        <c:when test="${currentPage eq i}">
                                            <li class="active"><a href="#"> ${i}</a></li>
                                            </c:when>
                                            <c:otherwise>
                                            <li><a  href="controller?section=pagination&pageHome=${i}">${i}</a></li>
                                            </c:otherwise>
                                        </c:choose>

                                </c:forEach>
                                <c:if test="${currentPage lt applicationScope.noOfPages}">
                                    <li class="page-item"><a class="page-link" href="controller?section=pagination&pageHome=${currentPage + 1}">Next</a></li> 
                                    </c:if>         

                            </ul>

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

























