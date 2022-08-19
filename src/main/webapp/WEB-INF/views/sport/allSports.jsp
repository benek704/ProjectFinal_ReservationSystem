<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sporty</title>
</head>
<body>
<table>Sporty
    <tr>
        <th>lp.</th>
        <th>Nazwa</th>
        <th>Dostępne kluby</th>
    </tr>
    <c:forEach items="${Sport}" var="sport">
        <tr>
            <td>${sport.id}</td>
            <td>${sport.name}</td>
            <td><a href="<c:url value="/Clubs/${sport.id}"/>"> Kluby</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
