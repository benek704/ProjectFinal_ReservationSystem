<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>Wszystkie kluby ze sportem
    <tr>
        <th>Nazwa</th>
        <th>Miasto</th>
        <th>Dodatkowe informacje</th>
    </tr>

    <c:forEach items="${Club}" var="club">
        <tr>
            <td>${club.name}</td>
            <td>${club.city}</td>
            <td><a href="<c:url value="/clubInfo/${club.id}"/>">Więcej informacji o klubie</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
