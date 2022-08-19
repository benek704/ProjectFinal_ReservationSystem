<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
    <title>${Club.name}</title>

    <tr>
        <th>Nazwa</th>
        <th>Miasto</th>
        <th>Adres</th>
        <th>Informacje</th>
        <th>Email</th>
        <th>Usuń klub</th>

    </tr>

    <tr>
        <td>${Club.name}</td>
        <td>${Club.city}</td>
        <td>${Club.adres}</td>
        <td>${Club.information}</td>
        <td>${Club.email}</td>
        <td><a href="<c:url value="/deleteClub/${Club.id}"/>"> Usuń</a></td>
    </tr>
</table>

<table>
    <title>Obiekty sportowe</title>
    <tr>
        <th>Nazwa</th>
        <th>Czas otwarcia</th>
        <th>Czas zamknięcia</th>
        <th>Usuń obiekt</th>
    </tr>
    <c:forEach items="${SportObject}" var="sportObject">
        <tr>
            <td>${sportObject.name}</td>
            <td>${sportObject.start}</td>
            <td>${sportObject.end}</td>
            <td><a href="<c:url value="/deleteSportObject/${sportObject.id}"/>"> Usuń</a></td>


        </tr>
    </c:forEach>


</table>
<a href="<c:url value="/addSportObject"/>"> Dodaj obiekt</a>
<br><a href="<c:url value="/addReservations"/>">Dodaj Rezerwacje></a>


</body>
</html>
