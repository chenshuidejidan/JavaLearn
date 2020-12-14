<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/16
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        span{
            font-size: 10px;
            color:red;
        }
    </style>
</head>
<body>
<form action="/login/CheckCheckCode" method="post">
    <input type="text" placeholder="  请输入用户名" name="username"/><br>
    <input type="text" placeholder="  请输入密码" name="password"/><br>
    <input class="inputVerifyInTable" name="verifyCode" id="verifyCode">
    <img id="loginCode" src="/login/CheckCode" align="center"/><a id="loginChangeCode" href="javascript:void(0)" font-size="10px">看不清？换一张</a>
    <%
        if("wrong".equals(request.getAttribute("checkCodeCheck"))){
            out.print("<span>验证码输入错误</span><br>");
        }
        if("wrong".equals(request.getAttribute("checkPassword"))){
            out.print("<span>用户名或密码有误</span><br>");
        }
        request.removeAttribute("checkCodeCheck");
        request.removeAttribute("checkCodeCheck");
    %>
    <br><input type="submit" value="登陆">
</form>
</body>
<script>
    var image = document.getElementById("loginCode")
    image.onclick = function () {
        var date = new Date().getTime();
        image.src = "/login/CheckCode?" + date;
    }

    var change = document.getElementById("loginChangeCode")
    change.onclick = function () {
        var date = new Date().getTime();
        image.src = "/login/CheckCode?" + date;
    }
</script>
</html>
