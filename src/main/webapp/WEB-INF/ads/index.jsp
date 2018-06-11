<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container my-4">
    <h1 class="text-center">Here Are all the ads!</h1>


    <c:forEach var="ad" items="${ads}">
        <div class="card mx-auto my-5 w-75">
            <div class="card-header">
                <h2>${ad.title}</h2>
            </div>
            <div class="card-body">
                <p class="card-text">${ad.description}</p>
            </div>
            <div class="card-footer text-muted">
                <a href="#" class="btn btn-primary">Edit</a>
                <a href="#" class="btn btn-primary">Delete</a>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
