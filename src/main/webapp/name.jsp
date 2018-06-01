<%--
  Created by IntelliJ IDEA.
  User: xronos
  Date: 6/1/18
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Name JSP!</title>
</head>
<body>

<c:if test="${empty name}">
    <h1>Howdy, Partner!</h1>
    <form method="POST" action="/name">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" placeholder="enter your name here, please" autofocus>
        <button>Send Name</button>
    </form>
</c:if>
<c:if test="${not empty name}">
    <h1>Well, howdy, ${name}</h1>
</c:if>


<p>if the request has a name already, then say Hi to that name... Otherwise, show the form.</p>

</body>
</html>
