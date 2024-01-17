<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Place</title>
    <style><%@include file="/styles/main.css"%></style>
    <style><%@include file="/styles/navbar.css"%></style>
</head>
<body>
<nav>
    <table>
        <th>
        <td><%@include file="/assets/logo.svg"%></td>
        <td><a href="place" class="sign_word">Таблица мест</a></td>
        <td><a href="hall" class="sign_word">Таблица залов</a></td>
        <td><a href="category" class="sign_word">Таблица категорий мест</a></td>
        </th>
    </table>
</nav>
<header>
    Таблица МЕСТА
</header>
<div style="text-align: center">
    <table style="margin: auto">
        <tr>
            <th>Id места</th>
            <th>Ряд</th>
            <th>Место</th>
            <th>Категория</th>
            <th>Зал</th>
        </tr>
        <c:forEach items="${places}" var="place">
            <tr>
                <td>${place.id}</td>
                <td>${place.row}</td>
                <td>${place.place}</td>
                <td>${place.category}</td>
                <td>${place.id_hall}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<form action="" method="post">
    <span>Введите id:</span>
    <input type="text" name="id">
    <br>
    <span>Введите ряд:</span>
    <input type="text" name="row">
    <br>
    <span>Введите место:</span>
    <input type="text" name="place">
    <br>
    <span>Введите категорию:</span>
    <input type="text" name="category">
    <br>
    <span>Введите зал:</span>
    <input type="text" name="hall">
    <br>
    <input type="hidden" name="pageName" value="add"/>
    <input type="submit" class="button" value="Добавить запись">
</form>
<form action="" method="post">
    <span>Введите id:</span>
    <input type="text" name="id_del">
    <br>
    <input type="hidden" name="pageName" value="delete"/>
    <input type="submit" class="button" value="Удалить запись">
</form>
</body>
</html>
