<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 19.04.2018
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.domain.Picture" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список картин</title>
    <link rel="stylesheet" href="nnn.css" type="text/css"/>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
    <link rel="stylesheet" href="menu.css" type="text/css"/>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
    <script>
        var i1 = 0;var i2 = 0;

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
            document.getElementById("description").disabled = "true";
            document.getElementById("photo").disabled = "true";
            document.getElementById("technique").disabled = "true";
            document.getElementById("genre").disabled = "true";
            document.getElementById("artist").disabled = "true";
        }

        function myFunction() {
            var f = this.parentNode.parentNode.getElementsByTagName("td");
            i1 = this.id;
            var j = 0;
            document.getElementById("id").value = this.id;
            document.getElementById("name").value = f[0].innerText;
            document.getElementById("description").innerText = f[1].innerText;
            document.getElementById("photo").value = f[2].innerText;
            document.getElementById("technique").value =  f[3].innerText;
            var i = f[4].innerText;
            for (j = 0; j < document.getElementById("genre").options.length; ++j) {
                if (document.getElementById("genre").options[j].value == i) {
                    document.getElementById("genre").options.selectedIndex = j;
                }
            }
            i = f[5].innerText;
            for (j = 0; j < document.getElementById("artist").options.length; ++j) {
                if (document.getElementById("artist").options[j].value == i) {
                    document.getElementById("artist").options.selectedIndex = j;
                }
            }
            PopUpShowUpd();
        }

        function change() {
            $('#name').prop('disabled', false);
            $('#description').prop('disabled', false);
            $('#photo').prop('disabled', false);
            $('#technique').prop('disabled', false);
            $('#genre').prop('disabled', false);
            $('#artist').prop('disabled', false);
            document.getElementById("ed").style.display = "none";
            document.getElementById("sv").style.display = "inline";
            document.getElementById("dl").style.display = "inline";
        }
    </script>
</head>
<body>
<jsp:useBean id="simpleBean" class="main.controller.PictureController"/>
<jsp:useBean id="genreBean" class="main.controller.GenreController"/>
<jsp:useBean id="artistBean" class="main.controller.ArtistController"/>
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
                <tr><td id="title">Картины<a onclick="PopUpShow()">Добавить</a></td></tr>
                <c:forEach var="picture" items="${simpleBean.getAll()}">
                    <tr>
                        <td hidden="hidden"><c:out value="${picture.getName()}"/></td>
                        <td hidden="hidden"><c:out value="${picture.getDescription()}"/></td>
                        <td hidden="hidden"><c:out value="${picture.getPhoto()}"/></td>
                        <td hidden="hidden"><c:out value="${picture.getTechnique()}"/></td>
                        <td hidden="hidden"><c:out value="${picture.getGenre_id()}"/></td>
                        <td hidden="hidden"><c:out value="${picture.getArtist_id()}"/></td>
                        <td><input type="button" name="lis" id="${picture.getId()}" value="${picture.getName()}"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="b-popup" id="popup1">
            <div class="b-popup-content" >
                <form action="PictureServlet" method="post">
                    <p>Название<br><input type="text" name="name" value="название"></p>
                    <p>Фото<br><input type="text" name="photo" value="ссылка на фото"></p>
                    <p>Техника<br><input type="text" name="technique" value="техника"></p>
                    <p>Жанр<br>
                        <select name="genre" >
                            <c:forEach var="picture" items="${genreBean.getAll()}">
                                <option  id="${picture.getName()}" value="${picture.getId()}">${picture.getName()}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Художник<br>
                        <select name="artist">
                            <c:forEach var="picture" items="${artistBean.getAll()}">
                                <option  id="${picture.getName()}" value="${picture.getId()}">${picture.getName()}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Описание<br><textarea name="description">описание</textarea></p>
                    <p><input type="submit" name="add" value="Добавить">
                    <input type="button" name="cancel" onclick="PopUpHide()" value="Отмена"></p>
                </form>
            </div>
        </div>

        <div class="b-popup" id="popup2">
            <div class="b-popup-content" >
                <form action="PictureServlet" id="popupform" method="post">
                    <p hidden="hidden"><input type="text" id="id" name="id" value=название"></p>
                    <p>Название<br><input type="text" name="name" id="name" value="название"></p>
                    <p>Фото<br><input type="text" name="photo" id="photo" value="ссылка на фото"></p>
                    <p>Техника<br><input type="text" name="technique" id="technique" value="техника"></p>
                    <p>Жанр<br>
                        <select name="genre" id="genre">
                            <c:forEach var="picture" items="${genreBean.getAll()}">
                                <option  id="${picture.getName()}" value="${picture.getId()}">${picture.getName()}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Художник<br>
                        <select name="artist" id="artist">
                            <c:forEach var="picture" items="${artistBean.getAll()}">
                                <option  id="${picture.getName()}" value="${picture.getId()}">${picture.getName()}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>Описание<br><textarea id="description" name="description">описание</textarea></p>
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
