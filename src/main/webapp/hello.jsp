<%--
  Created by IntelliJ IDEA.
  User: xronos
  Date: 5/31/18
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Java (for logic) in the JSP is below --%>
<%

    String message = "";

    // check to see if the form was submitted
    if("POST".equals(request.getMethod())) {

        String name = request.getParameter("name");

        if(name.equalsIgnoreCase("bob")) {
            message = "OMG, It's Bob, I've heard so much about you. Welcome!";
        } else {
            message = "Hello, " + name + " it is nice to meet you.";
        }
    }

%>
<html>
<head>
    <title>H E L L O</title>
</head>
<body>
<%@ include file="navbar.jsp"%>

<h1>H E L L O</h1>
<h2><%= message %></h2>

<form action="/hello.jsp" method="POST">
    <label for="name">name</label>
    <input type="text" name="name" id="name" placeholder="Please input your name" focus required>
    <button type="submit">Share your name</button>
</form>

</body>
</html>
