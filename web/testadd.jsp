<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 15.04.2018
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:useBean id="simpleBean" class="main.controller.ArtistController"/>
<!-- <%= simpleBean.getAll().get(0).getName()%> -->
Начальное значение свойства:
    <div>
        <table>
    <c:forEach var="artist" items="${simpleBean.getAll()}">
        <tr>
            <td><c:out value="${artist.getName()}"/></td>
            <td><c:out value="${artist.getBio()}"/></td>
            <td><c:out value="${artist.getCountry()}"/></td>
            <td><c:out value="${artist.getBirth_date()}"/></td>
            <td><c:out value="${artist.getDeath_date()}"/></td>
        </tr>
    </c:forEach>
        </table>
    </div>
</body>
</html>
