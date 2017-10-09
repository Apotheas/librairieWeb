<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello CataPanier!</h1>
        
        <jsp:include page="/controller?section=catalog" flush="true" />
        <hr>
        <jsp:include page="/controller?section=affichePanier" flush="true" />
        
        
      
        
        
    </body>
</html>
