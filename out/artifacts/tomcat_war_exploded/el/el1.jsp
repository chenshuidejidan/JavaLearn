<%@ page import="cn.hit.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/19
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setUsername("小明");
    user.setPassword("xiaoming");
    request.setAttribute("user",user);
%>

${requestScope.user}
${requestScope.user.username}

</body>
</html>
