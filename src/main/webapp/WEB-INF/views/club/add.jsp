<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie klubu</title>
</head>
<body>
<%--@elvariable id="club" type="pl.benek704.projectfinal_reservationsystem.model.Club"--%>
<form:form modelAttribute="club">
    <form:hidden path="id"/>
    Nazwa:<form:input path="name"/>
    Email:<form:input path="email"/>
    Hasło:<form:input path="password"/>
    Adres:<form:input path="adres"/>
    Miasto:<form:input path="city"/>
    Informacje:<form:input path="information"/>

    Dostępne Sporty:<form:select path="sport.id">
    <form:options items="${Sport}" itemLabel="name" itemValue="id"/>
</form:select>
    <input type="submit"/>
</form:form>

</body>
</html>
