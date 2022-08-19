<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie użytkownika</title>
</head>
<body>
<%--@elvariable id="User" type="pl.benek704.projectfinal_reservationsystem.model.User"--%>
<form:form modelAttribute="User">
    <form:hidden path="id"/>
    Nazwa użytkownika:<form:input path="username"/>
    Email:<form:input path="email"/>
    Hasło:<form:input path="password"/>
    <input type="submit"/>
</form:form>

</body>
</html>
