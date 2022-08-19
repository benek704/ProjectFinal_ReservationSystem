<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>Rezerwacje
    <tr>
        <th>Początek</th>
        <th>Koniec</th>
        <th>Obiekt</th>
        <th>Użytkownik</th>
        <th>Usuń rezerwację</th>
    </tr>

    <c:forEach items="${Reservation}" var="reservation">
        <tr>
            <td>${reservation.start}</td>
            <td>${reservation.end}</td>
            <td>${reservation.sportObject.name}</td>
            <td>${reservation.user.username}</td>
            <td><a href="<c:url value="/deleteReservation/${reservation.id}"/>"> Usuń</a></td>

        </tr>
    </c:forEach>
</table>
<br><a href="<c:url value="/addReservations"/>">Dodaj Rezerwacje></a>

</body>
</html>
