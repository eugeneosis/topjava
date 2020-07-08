<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>User Meals</title>
    <style>
        .green { color: green; }
        .red { color: red; }
    </style>
</head>
<body>

<h3><a href="index.html">Home</a></h3>

<center>
    <h2>User Meals</h2>
    <br>
    <a href="meals?action=create">Add Meals</a>
</center>
<br/>

<br/>
<center>
    <table border="2">
        <c:forEach var="meals" items="${meals}">
            <jsp:useBean id="meals" scope="page" type="ru.javawebinar.topjava.model.Meal"/>
            <tr class="${meals.excess ? 'green' : 'red'}">
                <td>${meals.dateTime.toLocalDate()}</td>
                <td>${meals.dateTime.toLocalTime()}</td>
                <td>${meals.description}</td>
                <td>${meals.calories}</td>
                <td><a href="meals?action=update&id=${meals.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meals.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
