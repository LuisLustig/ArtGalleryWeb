<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 19.04.2018
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.domain.Picture" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Галерея</title>
    <link rel="stylesheet" href="nnn.css" type="text/css"/>
    <link href="cssbox.css" rel="stylesheet" type="text/css">
    <link href="styles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="menu.css" type="text/css"/>
    <style type="text/css"></style></head>

<body>
<jsp:useBean id="simpleBean" class="main.controller.PictureController"/>
<div id="wrapper">
    <header>

    </header>
    <nav>
        <ul class="top-menu">
            <li><a href="genres.jsp">Список жанров</a></li>
            <li><a href="artists.jsp">Список художников</a></li>
            <li><a href="pictures.jsp">Список картин</a></li>
            <li><a href="gallery.jsp">Галерея</a></li>
        </ul>
    </nav>
    <aside></aside>
    <div id="content">
<% int i = 0; %>
<c:forEach var="picture" items="${simpleBean.forShow()}">
    <div class="cssbox">
        <a id="image<%=i %>" href="#image<%=i %>"><img class="cssbox_thumb" src="pics/${picture[1]}" height="300" width="320">
            <span class="cssbox_full">
                <img src="pics/${picture[1]}">
                <span id="und">
                    «${picture[0]}»<br>
                    ${picture[3]}, ${picture[2]}
                </span>
            </span>
        </a>
        <a class="cssbox_close" href="#void"></a>
        <% if(i!=0) { %>
        <a class="cssbox_prev" href="#image<%=i-1 %>">&lt;</a>
        <% } if(i!=10) { %>
        <a class="cssbox_next" href="#image<%=i+1 %>">&gt;</a>
        <%}%>



    </div>
    <% i++; %>
</c:forEach>
    </div>
</div>
</body>
</html>
