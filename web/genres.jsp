<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 15.04.2018
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.domain.Genre" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
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
            document.getElementById("type").disabled = "true";
            document.getElementById("description").disabled = "true";
        }

        function myFunction() {
            var f = this.parentNode.parentNode.getElementsByTagName("td");
            document.getElementById("id").value = this.id;
            document.getElementById("name").value = f[0].innerText;
            document.getElementById("type").value = f[1].innerText;
            document.getElementById("description").innerText = f[2].innerText;
            PopUpShowUpd();
        }

        function change() {
            $('#name').prop('disabled', false);
            $('#type').prop('disabled', false);
            $('#description').prop('disabled', false);
            document.getElementById("ed").style.display = "none";
            document.getElementById("sv").style.display = "inline";
            document.getElementById("dl").style.display = "inline";
        }
    </script>
</head>

<body>
<jsp:useBean id="simpleBean" class="main.controller.GenreController"/>
<div>
    <table>
        <thead><tr><td>Название</td></tr></thead>
        <c:forEach var="genre" items="${simpleBean.getAll()}">
            <tr>
                <td hidden="hidden"><c:out value="${genre.getName()}"/></td>
                <td hidden="hidden"><c:out value="${genre.getType()}"/></td>
                <td hidden="hidden"><c:out value="${genre.getDescription()}"/></td>
                <td><input type="button" name="lis" id="${genre.getId()}" value="${genre.getName()}"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" onclick="PopUpShow()" value="Добавить">
</div>

<div class="b-popup" id="popup1">
    <div class="b-popup-content" >
        <form action="GenreServlet" method="post">
        <p><input type="text" name="name" value="название"></p>
        <p><input type="text" name="type" value="тип"></p>
        <p><textarea name="description">описание</textarea></p>
        <p><input type="submit" name="add" value="Добавить">
            <input type="button" name="cancel" onclick="PopUpHide()" value="Отмена"></p>
        </form>
    </div>
</div>

<div class="b-popup" id="popup2">
    <div class="b-popup-content" >
        <form action="GenreServlet" id="popupform" method="post">
            <p hidden="hidden"><input type="text" id="id" name="id" value=название"></p>
            <p><input type="text" name="name" id="name" value=название"></p>
            <p><input type="text" name="type" id="type" value="тип"></p>
            <p><textarea name="description" id ="description">описание</textarea></p>
            <p>
                <input type="button" id="ed" onclick="change()" value="Редактировать">
                <input type="submit" name="update" id="sv" value="Сохранить">
                <input type="submit" name="delete" id="dl" value="Удалить">
                <input type="button" name="cancel" onclick="PopUpHideUpd()" value="Назад">
            </p>
        </form>
    </div>
</div>

<style>

    #sv{
        display: inline;
    }
    #ed{
        display: inline;
    }
    #dl{
        display: inline;
    }
    *{
        font-family: Areal;
    }
    .b-container{
        width:200px;
        height:150px;
        background-color: #ccc;
        margin:0px auto;
        padding:10px;
        font-size:30px;
        color: #fff;
    }
    .b-popup{
        width:100%;
        min-height:100%;
        background-color: rgba(0,0,0,0.5);
        overflow:hidden;
        position:fixed;
        top:0px;
    }
    .b-popup .b-popup-content{
        margin:40px auto 0px auto;
        width: 50%;
        height: auto;
        padding:10px;
        background-color: #c5c5c5;
        border-radius:5px;
        box-shadow: 0px 0px 10px #000;
    }
</style>
<script>
    var inputs = document.getElementsByName("lis");
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener("click", myFunction);
    }
</script>
</body>
</html>
