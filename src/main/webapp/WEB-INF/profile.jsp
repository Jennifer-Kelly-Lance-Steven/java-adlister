<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
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
                <form method="post" action="/ads/delete" >
                    <button type="submit" name="id" value="${ad.id}" class="btn btn-primary">
                        Delete
                    </button>
                </form>
            </div>
<<<<<<< HEAD
<c:forEach var="ad" items="${ads}">
    <div class="card mx-auto my-5 w-75">
        <div class="card-header">
            <h2>${ad.title}</h2>
        </div>
        <div class="card-body">
            <p class="card-text">${ad.description}</p>
        </div>
        <div class="card-footer text-muted">
            <a href="/ads/edit?${ad.id}" class="btn btn-primary" role="button">
                Edit
            </a>
            <form method="post" action="/ads/delete">
                <button type="submit" name="id" value="${ad.id}" class="btn btn-primary clear-left mr-5">
                    Delete
                </button>
            </form>
        </div>
    </div>
</c:forEach>
=======
        </div>
    </c:forEach>
>>>>>>> 644af994c2d4d3a8d085da25f98f33552ffb0db7

<jsp:include page="partials/footer.jsp"/>
</body>
</html>
