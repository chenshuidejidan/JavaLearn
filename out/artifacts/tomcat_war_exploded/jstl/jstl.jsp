<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    c:if标签
        1.属性：test（必须属性），接收boolean，为true时显示if标签体的内容
        2.一般结合EL表达式使用，if标签没有else的情况
    c:forEach
        1.begin:表示开始值(包含)
        2.end：结束值(包含)
        3.var：临时变量
        4.step：步长
        5.varStatus：循环状态对象
            varStatus.index ：容器中元素的索引，从0开始
            varStatus.count ：循环计次，从1开始
--%>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>
<c:if test="${not empty requestScope.list}">
    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str} <br>
    </c:forEach>
</c:if>
<div>=============================================</div>
<c:forEach begin="1" end="10" var="i" step="3" varStatus="s">
${i}  ${s.index}  ${s.count}<br>
</c:forEach>
</body>
</html>
