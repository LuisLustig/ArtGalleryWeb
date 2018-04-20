<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 19.04.2018
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.domain.Artist" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список художников</title>
    <link rel="stylesheet" href="nnn.css" type="text/css"/>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
    <link rel="stylesheet" href="menu.css" type="text/css"/>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script>
        $(document).ready(function(){
            PopUpHide();
            PopUpHideUpd();
        });
        function PopUpShow(){
            $("#popup1").show();
        }
        function PopUpHide(){
            $("#popup1").hide();
        }

        function PopUpShowUpd(){
            $("#popup2").show();
        }
        function PopUpHideUpd(){
            $("#popup2").hide();
            document.getElementById("ed").style.display = "inline";
            document.getElementById("sv").style.display = "none";
            document.getElementById("dl").style.display = "none";
            document.getElementById("name").disabled = "true";
            document.getElementById("bio").disabled = "true";
            document.getElementById("country").disabled = "true";
            document.getElementById("bdate").disabled = "true";
            document.getElementById("ddate").disabled = "true";

        }

        function myFunction() {
            var f = this.parentNode.parentNode.getElementsByTagName("td");
            document.getElementById("id").value = this.id;
            document.getElementById("name").value = f[0].innerText;
            document.getElementById("country").value = f[1].innerText;
            document.getElementById("bio").innerText = f[2].innerText;
            document.getElementById("bdate").value = f[3].innerText;
            document.getElementById("ddate").value = f[4].innerText;
            PopUpShowUpd();
        }

        function change() {
            $('#name').prop('disabled', false);
            $('#bio').prop('disabled', false);
            $('#country').prop('disabled', false);
            $('#bdate').prop('disabled', false);
            $('#ddate').prop('disabled', false);
            document.getElementById("ed").style.display = "none";
            document.getElementById("sv").style.display = "inline";
            document.getElementById("dl").style.display = "inline";
        }
    </script>
</head>
<body>
<jsp:useBean id="simpleBean" class="main.controller.ArtistController"/>
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
        <div>
            <table>
                <tr><td id="title">Художники<a onclick="PopUpShow()">Добавить</a></td></tr>
                <c:forEach var="artist" items="${simpleBean.getAll()}">
                    <tr>
                        <td hidden="hidden"><c:out value="${artist.getName()}"/></td>
                        <td hidden="hidden"><c:out value="${artist.getCountry()}"/></td>
                        <td hidden="hidden"><c:out value="${artist.getBio()}"/></td>
                        <td hidden="hidden"><c:out value="${artist.getBirth_date()}"/></td>
                        <td hidden="hidden"><c:out value="${artist.getDeath_date()}"/></td>
                        <td><input type="button" name="lis" id="${artist.getId()}" value="${artist.getName()}"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="b-popup" id="popup1">
            <div class="b-popup-content" >
                <form action="ArtistServlet" method="post">
                    <p>Название<br><input type="text" name="name" value="название"></p>
                    <p>Страна<br><input type="text" name="country" value="страна"></p>
                    <p>Дата рождения<br><input type="date" name="bdate" value="Дата рождения"></p>
                    <p>Дата смерти<br><input type="date" name="ddate" value="Дата смерти"></p>
                    <p>Биография<br><textarea name="bio">описание</textarea></p>
                    <p><input type="submit" name="add" value="Добавить">
                        <input type="button" name="cancel" onclick="PopUpHide()" value="Отмена"></p>
                </form>
            </div>
        </div>

        <div class="b-popup" id="popup2">
            <div class="b-popup-content" >
                <form action="ArtistServlet" id="popupform" method="post">
                    <p hidden="hidden"><input type="text" id="id" name="id" value=название"></p>
                    <p>Название<br><input type="text" name="name" id="name" value="название"></p>
                    <p>Страна<br><input type="text" name="country" id="country" value="страна"></p>
                    <p>Дата рождения<br><input type="date" name="bdate" id="bdate" value="Дата рождения"></p>
                    <p>Дата смерти<br><input type="date" name="ddate" id="ddate" value="Дата смерти"></p>
                    <p>Биография<br><textarea name="bio" id="bio">описание</textarea></p>
                    <p>
                        <input type="button" id="ed" onclick="change()" value="Редактировать">
                        <input type="submit" name="update" id="sv" value="Сохранить">
                        <input type="submit" name="delete" id="dl" value="Удалить">
                        <input type="button" name="cancel" onclick="PopUpHideUpd()" value="Назад">
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    var inputs = document.getElementsByName("lis");
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener("click", myFunction);
    }
</script>
</body>
</html>
