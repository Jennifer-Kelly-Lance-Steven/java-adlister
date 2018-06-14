<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sinergetic
  Date: 6/13/18
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <c:forEach var="ad"  items="${ads}" varStatus="status">
        <div class="card mx-auto my-5 w-75">
            <div class="card-header">
                <h2><a href="/ads/show?id=${ad.id}&userId=${ad.userId}" class="text-secondary nav-link">${ad.title}</a>
                </h2>
            </div>
            <div class="card-body">
                <p class="card-text">${ad.description}</p>
            </div>
            <div class="card-footer text-muted">
                <h3>This ad created by: ${}</h3>
                <p><a href="emailto:${user.getEmail()}">${user.getEmail()}</a></p>
            </div>
        </div>
    </c:forEach>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>
