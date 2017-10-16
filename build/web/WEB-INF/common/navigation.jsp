<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<ul id="menu-accordeon">
    
    
    <span>Evenements
    <c:forEach var="event" items="${event}">
        <li><a href='controller?event=${event.nameOccasion}'>${event.nameOccasion}  </a> </li>            
    </c:forEach>
      </span>
    <br>
    <span> Categories 
    <c:forEach var="theme" items="${theme}">
        <li><a href='controller?theme=${theme.nameTheme}'>${theme.nameTheme}  </a>
            <ul>
                <c:forEach var="subs" items="${theme.getSubList(theme.nameTheme)}">
                    <li><a href='controller?theme=${theme.nameTheme}&sub=${subs.nameSubTheme}'>${subs.nameSubTheme}</a></li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
    </span>
    
        
</ul>