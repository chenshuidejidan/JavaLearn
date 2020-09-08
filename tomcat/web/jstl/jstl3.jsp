<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.hit.domain.User" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/20
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List userList = new ArrayList<>();
    userList.add(new User("小明","xiaoming"));
    userList.add(new User("小强","xiaoqiang"));
    userList.add(new User("小张","xiaozhang"));

    request.setAttribute("list",userList);
%>

<table align="center">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="user" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr>
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="aqua">
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
