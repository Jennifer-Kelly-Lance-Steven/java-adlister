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

    <c:if test="${not empty searchAd}">
        <h1 class="text-center">Here are all the ads!</h1>
    </c:if>
    <c:if test="${empty searchAd}">
        <h1 class="text-center">Your search returned no results</h1>
    </c:if>


    <c:forEach var="searchAd" items="${searchAds}" varStatus="status">
        <div class="card mx-auto my-5 w-75">
            <div class="card-header">
                <h2><a href="/ads/show?id=${searchAd.getId()}&userId=${searchAd.getUserId()}"
                       class="text-secondary nav-link">${searchAd.getTitle()}</a>
                </h2>
            </div>
            <div class="card-body">
                <p class="card-text">${searchAd.getDescription()}</p>
            </div>
            <div class="card-footer text-muted">
                <h3>This ad created by: ${searchAd.getUsername()}</h3>
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <p><a href="emailto:${searchAd.getEmail()}">${searchAd.getEmail()}</a></p>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>