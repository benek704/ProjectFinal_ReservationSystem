<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="sportObject" type="pl.benek704.projectfinal_reservationsystem.model.SportObject"--%>
<form:form modelAttribute="sportObject">
    <form:hidden path="id"/>
    Nazwa:<form:input path= "name"/>
    Godzina Otwarcia:<form:input type="time" path="start"/>
    Godzina Zamknięcia:<form:input type="time" path="end"/>
    <form:select path="club.id">
        <form:options items="${Club}" itemLabel="name" itemValue="id"/>
    </form:select>
    <input type="submit"/>
</form:form>



</body>
</html>
