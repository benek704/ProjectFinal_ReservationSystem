<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>Wszystkie kluby
<tr>
    <th>Nazwa</th>
    <th>Miasto</th>
</tr>

<c:forEach items="${Club}" var="club">
<tr>
    <td>${club.name}</td>
    <td>${club.city}</td>
    <td><a href="<c:url value="/clubInfo/${club.id}"/>">Więcej informacji o klubie</a></td>
</tr>
    </c:forEach>
</table>
<br><a href="<c:url value="/addClub"/>">Dodaj klub></a>
</body>
</html>
