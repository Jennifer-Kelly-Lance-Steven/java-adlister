<%--
  Created by IntelliJ IDEA.
  User: xronos
  Date: 5/31/18
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>H E L L O</title>
</head>
<body>
<%@ include file="navbar.jsp"%>

<h1>H E L L O</h1>
<h2>This is a message from the future.</h2>

<p>"name" parameter: <%= request.getParameter("name") %></p>
<p>"name" parameter: ${param.name}</p>


</body>
</html>
