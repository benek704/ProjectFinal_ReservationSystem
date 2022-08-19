<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="reservation" type="pl.benek704.projectfinal_reservationsystem.model.Reservation"--%>
<form:form modelAttribute="reservation">
    <form:hidden path="id"/>
    Początek:<form:input type="datetime-local" path="start"/>
    Koniec:<form:input type="datetime-local" path="end"/>
    Obiekt sportowy<form:select path="sportObject.id">
    <form:options items="${SportObject}" itemLabel="name" itemValue="id"/>
</form:select>
    Użytkownik<form:select path="user.id">
    <form:options items="${User}" itemLabel="username" itemValue="id"/>
</form:select>
    <input type="submit"/>
</form:form>

</body>
</html>
