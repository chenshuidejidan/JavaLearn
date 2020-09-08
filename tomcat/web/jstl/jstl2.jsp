<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    使用when标签做判断
--%>
<%
    request.setAttribute("number",3);
%>
123
<c:choose>
    <c:when test="${requestScope.number==1}">星期一</c:when>
    <c:when test="${requestScope.number==2}">星期二</c:when>
    <c:when test="${requestScope.number==3}">星期三</c:when>
    <c:when test="${requestScope.number==4}">星期四</c:when>
    <c:when test="${requestScope.number==5}">星期五</c:when>
</c:choose>
</body>
</html>
