<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${ad.title}"/>
    </jsp:include>

</head>

<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container text-center mt-5">
    <div class="row">
        <div class="col">
            <h1>${ad.title}</h1>
            <p>${ad.description}</p>
            <p>This ad posted by: <strong>${user.getUsername()}</strong></p>
            <c:if test="${sessionScope.user != null}">
            <p><a href="emailto:${user.getEmail()}">${user.getEmail()}</a></p>
            </c:if>
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/partials/footer.jsp"/>

</body>
</html>
