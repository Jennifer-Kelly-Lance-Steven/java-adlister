<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
    <style>
        .delete{
            margin: 0;
            padding: 0;
            width: 50px;
            display: inline-block;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>
</div>

    <c:forEach var="ad" items="${ads}">
        <div class="card mx-auto my-5 w-75">
            <div class="card-header">
                <h2>${ad.title}</h2>
            </div>
            <div class="card-body">
                <p class="card-text">${ad.description}</p>
            </div>
            <div class="card-footer text-muted">
                        <a href="/ads/edit?id=${ad.id}&oldTitle=${ad.title}&oldDescription=${ad.description}" class="btn btn-primary">
                            Edit
                        </a>
                <form class="delete" method="post" action="/ads/delete" >
                    <button type="submit" name="id" value="${ad.id}" class="btn btn-primary">
                        Delete
                    </button>
                </form>
            </div>
        </div>
    </c:forEach>

<jsp:include page="partials/footer.jsp"/>
</body>
</html>
