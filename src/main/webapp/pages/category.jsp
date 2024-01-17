<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
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
    Таблица КАТЕГОРИИ
</header>
<div style="text-align: center">
    <table style="margin: auto">
        <tr>
            <th>Id категории</th>
            <th>Название</th>
            <th>Стоимость</th>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.category}</td>
                <td>${category.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<form action="" method="post">
    <span>Введите id:</span>
    <input type="text" name="id">
    <br>
    <span>Введите название:</span>
    <input type="text" name="category">
    <br>
    <span>Введите стоимость:</span>
    <input type="text" name="price">
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
