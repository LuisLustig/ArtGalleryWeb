<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 11.04.2018
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="testadd.jsp">
    <input type="submit" value="Вывести всех">
</form>
<form action="testadd.jsp">
    <input type="submit" value="Вывести всех">
</form>
<form action="artistadd.jsp">
    <input type="submit" value="Добавить художника">
</form>
<form action="testadd.jsp">
    <input type="submit" value="Вывести всех">
</form>
<% for (int i = 0; i < 10; i++) {%>
Hi<br>
<% } %>
</body>
</html>
