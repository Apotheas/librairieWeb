<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="my-4">Shop Name</h1>

<ul id="menu-accordeon">
    <c:forEach var="theme" items="${theme}">
        <li><a href='controller?theme=${theme.nameTheme}'>${theme.nameTheme}  </a>
            <ul>
                <c:forEach var="subs" items="${theme.getSubList(theme.nameTheme)}">
                    <li><a href='controller?theme=${theme.nameTheme}&sub=${subs.nameSubTheme}'>${subs.nameSubTheme}</a></li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>